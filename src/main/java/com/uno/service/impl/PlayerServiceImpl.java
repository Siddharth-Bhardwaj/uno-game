package com.uno.service.impl;

import com.uno.dtos.player.Player;
import com.uno.enums.GameStatus;
import com.uno.model.Game;
import com.uno.repository.GameRepository;
import com.uno.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.uno.enums.ErrorMessage.GAME_FINISHED;
import static com.uno.enums.ErrorMessage.GAME_IN_PROGRESS;
import static com.uno.enums.ErrorMessage.GAME_NOT_FOUND;
import static com.uno.enums.ErrorMessage.MAX_PLAYERS_REACHED;
import static com.uno.enums.ErrorMessage.PLAYER_ALREADY_EXISTS;
import static com.uno.enums.ErrorMessage.PLAYER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final GameRepository gameRepository;

    private static final int MAX_PLAYER_COUNT = 10;

    @Override
    public Player create(String name) {
        return Player.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .isActive(true)
                .build();
    }

    @Override
    public Game joinGame(String playerName, String gameId) {
        // todo: create unique game code (4-5 digits) for joining
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if (optionalGame.isEmpty()) {
            throw new IllegalArgumentException(GAME_NOT_FOUND.value);
        }
        Game game = optionalGame.get();
        validateGameBeforeJoining(playerName, game);
        game.getPlayers().add(create(playerName));
        return gameRepository.save(game);
    }

    @Override
    public Game leaveGame(String playerId, String gameId) {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if (optionalGame.isEmpty()) {
            throw new IllegalArgumentException(GAME_NOT_FOUND.value);
        }
        Game game = optionalGame.get();
        if (CollectionUtils.isEmpty(game.getPlayers())
                || game.getPlayers().stream().noneMatch(player -> playerId.equals(player.getId()))) {
            throw new IllegalArgumentException(PLAYER_NOT_FOUND.value);
        }
        List<Player> updatedPlayerList = game.getPlayers().stream()
                .peek(player -> {
                    if (playerId.equals(player.getId())) {
                        player.setActive(false);
                    }
                })
                .collect(Collectors.toList());
        game.setPlayers(updatedPlayerList);
        postProcessingAfterLeaving(game);
        return gameRepository.save(game);
    }

    private void postProcessingAfterLeaving(Game game) {
        game.getPlayers()
                .stream()
                .filter(player -> !player.isActive())
                .forEach(player -> {
                    if (!CollectionUtils.isEmpty(player.getCards())) {
                        game.getDiscardDeck().addAll(player.getCards());
                    }
                    player.setCards(new ArrayList<>());
                });
        if (game.getPlayers().stream().noneMatch(Player::isActive)) {
            game.setGameStatus(GameStatus.FINISHED);
        }
    }

    private void validateGameBeforeJoining(String playerName, Game game) {
        validateIfPlayerAlreadyExists(playerName, game);
        validatePlayerCount(game);
        validateGameStatus(game);
    }

    private void validateIfPlayerAlreadyExists(String playerName, Game game) {
        if (CollectionUtils.isEmpty(game.getPlayers())) {
            return;
        }
        if (game.getPlayers().stream()
                .anyMatch(player -> playerName.equalsIgnoreCase(player.getName()))) {
            throw new IllegalArgumentException(PLAYER_ALREADY_EXISTS.value);
        }

    }

    // todo: create custom exceptions
    private void validatePlayerCount(Game game) {
        if (CollectionUtils.isEmpty(game.getPlayers())
                || game.getPlayers().size() + 1 == MAX_PLAYER_COUNT) {
            throw new IllegalStateException(MAX_PLAYERS_REACHED.value);
        }
    }

    private void validateGameStatus(Game game) {
        if (GameStatus.IN_PROGRESS.equals(game.getGameStatus())) {
            throw new IllegalStateException(GAME_IN_PROGRESS.value);
        }
        if (GameStatus.FINISHED.equals(game.getGameStatus())) {
            throw new IllegalStateException(GAME_FINISHED.value);
        }
    }
}
