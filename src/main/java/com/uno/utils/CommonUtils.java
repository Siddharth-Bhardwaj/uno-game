package com.uno.utils;

import com.uno.dtos.player.Player;
import java.util.ArrayList;
import java.util.UUID;

public class CommonUtils {
  public static Player createPlayer(String name) {
    return Player.builder()
        .id(UUID.randomUUID().toString())
        .name(name)
        .isActive(true)
        .cards(new ArrayList<>())
        .build();
  }
}
