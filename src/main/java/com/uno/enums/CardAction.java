package com.uno.enums;

public enum CardAction {
  DRAW_2,
  REVERSE,
  SKIP,
  WILD,
  WILD_D4;

  public static CardAction fromString(String cardActionString) {
    try {
      return CardAction.valueOf(cardActionString);
    } catch (NullPointerException e) {
      return null;
    }
  }
}
