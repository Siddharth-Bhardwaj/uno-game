package com.uno.utils;

import static com.uno.dtos.Card.initializeDeck;
import static com.uno.utils.CommonUtils.createPlayer;

import com.uno.dtos.game.GameRequest;
import com.uno.dtos.player.Player;
import com.uno.enums.FlowType;
import com.uno.enums.GameStatus;
import com.uno.model.Game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import org.springframework.util.CollectionUtils;

public class GameUtils {
  public static void distributeCards(Game game) {
    if (CollectionUtils.isEmpty(game.getCardDeck())) {
      game.setCardDeck(initializeDeck());
    }
    Collections.shuffle(game.getCardDeck());
    game.getPlayers().stream()
        .filter(player -> CollectionUtils.isEmpty(player.getCards()))
        .forEach(player -> player.setCards(new ArrayList<>()));
    for (int i = 0; i < 7; i++) {
      game.getPlayers().forEach(player -> player.getCards().add(game.getCardDeck().pop()));
    }
  }

  // todo: add test that initialized game has null current card and discard deck and vice versa
  public static Game create(GameRequest gameRequest) {
    Player player = createPlayer(gameRequest.getPlayerName());
    return Game.builder()
        .gameType(gameRequest.getGameType())
        .players(List.of(player))
        .cardDeck(initializeDeck())
        .discardDeck(new Stack<>())
        .flowType(FlowType.CLOCKWISE)
        .gameStatus(GameStatus.CREATED)
        .turnTimeout(gameRequest.getTurnTimeout())
        .ownerPlayerId(player.getId())
        .build();
  }
}
