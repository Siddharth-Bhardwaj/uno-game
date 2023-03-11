package com.uno.controller;

import com.uno.model.Game;
import com.uno.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1.0/player")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
// todo: return exception message in response
//
// https://stackoverflow.com/questions/52183546/not-able-to-return-responseentity-with-exception-details-in-spring
public class PlayerController {
  private final PlayerService playerService;

  @PutMapping("/joinGame")
  ResponseEntity<Game> joinGame(@RequestParam String playerName, @RequestParam String gameId) {
    return ResponseEntity.ok(playerService.joinGame(playerName, gameId));
  }

  // todo: add custom annotation to check if player is present in game / owns the game
  @PutMapping("/leaveGame")
  @ExceptionHandler(IllegalArgumentException.class)
  ResponseEntity<Game> leaveGame(@RequestParam String playerId, @RequestParam String gameId)
      throws IllegalArgumentException {
    return ResponseEntity.ok(playerService.leaveGame(playerId, gameId));
  }
}
