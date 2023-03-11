package com.uno.service.impl;

import static com.uno.utils.GameUtils.create;
import static com.uno.utils.GameUtils.distributeCards;

import com.uno.dtos.game.GameRequest;
import com.uno.enums.GameStatus;
import com.uno.model.Game;
import com.uno.repository.GameRepository;
import com.uno.service.GameService;
import com.uno.service.PlayerService;
import com.uno.utils.GameUtils;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final PlayerService playerService;

    @Override
    public Game createGame(GameRequest gameRequest) {
        Game game = create(gameRequest);
        return gameRepository.save(game);
    }

    @Override
    public Game getGame(String gameId) {
        return gameRepository.findById(gameId).orElse(new Game());
    }

  @Override
  public Game startGame(String gameId, String playerId) {
    Optional<Game> optionalGame = gameRepository.findById(gameId);
    if (optionalGame.isEmpty() || !optionalGame.get().getOwnerPlayerId().equals(playerId)) {
      throw new IllegalArgumentException(
          "Either the game does not exist or the player is not authorized to start this game");
    }
    Game game = optionalGame.get();
    game.setGameStatus(GameStatus.IN_PROGRESS);
    distributeCards(game);
    game.setCurrentCard(game.getCardDeck().pop());
    Random random = new Random();
    game.setCurrentTurnPlayerId(
        game.getPlayers().get(random.nextInt(game.getPlayers().size())).getId());
    return gameRepository.save(game);
  }
}
