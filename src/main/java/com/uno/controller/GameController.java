package com.uno.controller;

import com.uno.dtos.game.GameRequest;
import com.uno.model.Game;
import com.uno.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1.0/game")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameController {
    private final GameService gameService;

    @PostMapping(value = "/create")
    ResponseEntity<Game> createGame(@RequestBody GameRequest gameRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.create(gameRequest));
    }
}
