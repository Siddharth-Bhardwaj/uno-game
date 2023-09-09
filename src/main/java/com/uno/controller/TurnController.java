package com.uno.controller;

import com.uno.model.Game;
import com.uno.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("v1.0/turn")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TurnController {

  private final GameService gameService;

  @MessageMapping
  @SendTo("/topic/turn")
  public Game executeTurn(String gameId) {
    return gameService.getGame(gameId);
  }
}
