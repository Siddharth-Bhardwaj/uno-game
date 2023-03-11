package com.uno.enums;

public enum ErrorMessage {
  GAME_NOT_FOUND("The specified game does not exist"),
  MAX_PLAYERS_REACHED("The game already has max number of allowed players"),
  GAME_IN_PROGRESS("The game is already in progress"),
  GAME_FINISHED("The game is already finished"),
  PLAYER_NOT_FOUND("The player does not exist in the specified game"),
  PLAYER_ALREADY_EXISTS("This name is already taken");

  public final String value;

  ErrorMessage(String value) {
    this.value = value;
  }
}
