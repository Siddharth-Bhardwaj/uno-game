package com.uno.dtos;

import com.uno.enums.CardAction;
import com.uno.enums.CardColor;
import com.uno.enums.CardValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.uno.enums.CardAction.fromString;
import static com.uno.enums.CardValue.ZERO;
import static com.uno.enums.CardValue.actionCardValues;
import static com.uno.enums.CardValue.numericalCardValues;
import static com.uno.enums.CardValue.wildCardValues;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    private CardColor color;
    private CardValue value;
    private CardAction action;
    private String slug;
    private boolean isSpecial;

    public static Stack<Card> initializeDeck() {
        List<Card> cards = Stream.of(initializeNumericalCards(), initializeActionCards(),
                        initializeWildCards())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        Collections.shuffle(cards);
        Stack<Card> cardStack = new Stack<>();
        cardStack.addAll(cards);
        return cardStack;
    }

    private static String getCardSlug(CardColor cardColor, CardValue value) {
        if (Objects.isNull(cardColor) && Objects.isNull(value)) {
            return null;
        }
        if (Objects.isNull(cardColor)) {
            return value.value;
        }
        if (Objects.isNull(value)) {
            return cardColor.name();
        }
        return cardColor.name().concat("_").concat(value.value);
    }

    private static List<Card> initializeNumericalCards() {
        return Arrays.stream(CardColor.values())
                .filter(cardColor -> !CardColor.BLACK.equals(cardColor))
                .map(cardColor -> new ArrayList<>(numericalCardValues).stream()
                        .map(cardValue -> Card.builder().color(cardColor)
                                .value(cardValue)
                                .action(fromString(cardValue.action))
                                .slug(getCardSlug(cardColor, cardValue))
                                .isSpecial(false)
                                .build())
                        .collect(Collectors.toList())
                        .stream()
                        // there are 2 cards for each color and number value except ZERO in a deck
                        .map(card -> {
                            if (ZERO.equals(card.getValue())) {
                                return List.of(card);
                            } else {
                                return List.of(card, card);
                            }
                        })
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<Card> initializeActionCards() {
        return Arrays.stream(CardColor.values())
                .filter(cardColor -> !CardColor.BLACK.equals(cardColor))
                .map(cardColor ->
                        new ArrayList<>(actionCardValues).stream()
                                .map(cardValue -> Card.builder()
                                        .color(cardColor)
                                        .value(cardValue)
                                        .action(fromString(cardValue.action))
                                        .slug(getCardSlug(cardColor, cardValue))
                                        .isSpecial(false)
                                        .build())
                                .collect(Collectors.toList())
                                .stream()
                                .map(card -> List.of(card, card))
                                .flatMap(Collection::stream)
                                .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<Card> initializeWildCards() {
        return wildCardValues.stream()
                .map(cardValue ->
                        Card.builder()
                                .color(CardColor.BLACK)
                                .value(cardValue)
                                .action(fromString(cardValue.action))
                                .slug(getCardSlug(null, cardValue))
                                .isSpecial(true)
                                .build())
                .collect(Collectors.toList())
                .stream()
                .map(card -> List.of(card, card, card, card))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
