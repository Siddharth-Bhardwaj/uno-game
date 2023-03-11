package com.uno.controller;

import com.uno.constants.HeaderConstants;
import com.uno.dtos.game.GameRequest;
import com.uno.model.Game;
import com.uno.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1.0/game")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameController {
  private final GameService gameService;

  @PostMapping(value = "/create")
  ResponseEntity<String> createGame(@RequestBody GameRequest gameRequest) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(gameService.createGame(gameRequest).getId());
  }

  @GetMapping(value = "/{gameId}")
  ResponseEntity<Game> getGameDetails(@PathVariable String gameId) {
    return ResponseEntity.status(HttpStatus.OK).body(gameService.getGame(gameId));
  }

  @PutMapping(value = "{gameId}/start")
  ResponseEntity<Game> startGame(
      @PathVariable String gameId, @RequestHeader(HeaderConstants.PLAYER_ID) String playerId) {
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(gameService.startGame(gameId, playerId));
  }
}
