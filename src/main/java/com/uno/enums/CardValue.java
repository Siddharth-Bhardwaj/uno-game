package com.uno.enums;

import java.util.Set;

public enum CardValue {
  ZERO("0", null),
  ONE("1", null),
  TWO("2", null),
  THREE("3", null),
  FOUR("4", null),
  FIVE("5", null),
  SIX("6", null),
  SEVEN("7", null),
  EIGHT("8", null),
  NINE("9", null),

  DRAW_2("D2", CardAction.DRAW_2.name()),
  REVERSE("REVERSE", CardAction.REVERSE.name()),
  SKIP("SKIP", CardAction.SKIP.name()),

  WILD("WILD", CardAction.WILD.name()),
  WILD_DRAW_4("WILD_D4", CardAction.WILD_D4.name());

  public final String value;
  public final String action;

  CardValue(String value, String action) {
    this.value = value;
    this.action = action;
  }

  public static final Set<CardValue> numericalCardValues =
      Set.of(ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE);

  public static final Set<CardValue> actionCardValues = Set.of(DRAW_2, REVERSE, SKIP);

  public static final Set<CardValue> wildCardValues = Set.of(WILD, WILD_DRAW_4);
}
