package com.uno.controller;

import com.uno.model.Game;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("v1.0/turn")
public class TurnController {
  @MessageMapping
  @SendTo("/topic/turn")
  public Game executeTurn(String gameId) {
    return null;
  }
}
