package com.uno.model;

import com.uno.dtos.Card;
import com.uno.dtos.player.Player;
import com.uno.enums.FlowType;
import com.uno.enums.GameStatus;
import com.uno.enums.GameType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document("game")
public class Game extends AuditModel {

    @Id
    private String id;

    private GameType gameType;

    private List<Player> players;

    private List<Card> cardDeck = new ArrayList<>();

    private List<Card> discardDeck = new ArrayList<>();

    private FlowType flowType;

    private GameStatus gameStatus;

    private String currentTurnPlayerId;

    private Card currentCard;

    private Integer turnTimeout;

    private String winnerPlayerId;

}

