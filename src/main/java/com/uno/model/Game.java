package com.uno.model;

import com.uno.dtos.game.Card;
import com.uno.enums.FlowType;
import com.uno.enums.GameStatus;
import com.uno.enums.GameType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("game")
public class Game {
    @Id
    private String id;

    private GameType gameType;

    private List<Player> players;

    private List<Card> cardDeck;

    private FlowType flowType;

    private GameStatus gameStatus;

    private String currentTurnPlayerId;

    private Card currentCard;

    private Integer turnTimeout;

    private String winnerPlayerId;
}
