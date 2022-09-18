package com.uno.service.impl;

import com.uno.dtos.game.GameRequest;
import com.uno.dtos.player.Player;
import com.uno.enums.FlowType;
import com.uno.enums.GameStatus;
import com.uno.model.Game;
import com.uno.repository.GameRepository;
import com.uno.service.GameService;
import com.uno.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.uno.dtos.Card.initializeDeck;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final PlayerService playerService;

    @Override
    public Game create(GameRequest gameRequest) {
        Game game = createGame(gameRequest);
        return gameRepository.save(game);
    }

    // todo: add test that initialized game has null current card and discard deck and vice versa
    private Game createGame(GameRequest gameRequest) {
        Player player = playerService.create(gameRequest.getPlayerName());
        return Game.builder()
                .gameType(gameRequest.getGameType())
                .players(List.of(player))
                .cardDeck(initializeDeck())
                .discardDeck(new ArrayList<>())
                .flowType(FlowType.CLOCKWISE)
                .gameStatus(GameStatus.CREATED)
                .turnTimeout(gameRequest.getTurnTimeout())
                .build();
    }
}
