package com.uno.dtos.game;

import com.uno.enums.GameType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameRequest {
  private GameType gameType;

  private String playerName;

  private Integer turnTimeout;
}
