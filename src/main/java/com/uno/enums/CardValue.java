package com.uno.enums;

public enum CardValue {
    ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"),

    DRAW_2("D2"), REVERSE("REVERSE"), SKIP("SKIP"),

    WILD("WILD"), WILD_DRAW_4("WILD_D4");

    private String value;

    CardValue(String value) {
        this.value = value;
    }
}
