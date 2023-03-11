package com.uno.model;

import com.uno.dtos.Card;
import com.uno.dtos.player.Player;
import com.uno.enums.FlowType;
import com.uno.enums.GameStatus;
import com.uno.enums.GameType;
import java.util.List;
import java.util.Stack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document("game")
public class Game extends AuditModel {

  @Id private String id;

  private GameType gameType;

  private List<Player> players;

  private Stack<Card> cardDeck = new Stack<>();

  private Stack<Card> discardDeck = new Stack<>();

  private FlowType flowType;

  private GameStatus gameStatus;

  private String currentTurnPlayerId;

  private Card currentCard;

  private Integer turnTimeout;

  private String winnerPlayerId;

  private String ownerPlayerId;
}
