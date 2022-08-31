package com.uno.service.impl;

import com.uno.dtos.game.GameRequest;
import com.uno.model.Game;
import com.uno.repository.GameRepository;
import com.uno.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    @Override
    public Game create(GameRequest gameRequest) {
        Game game = Game.builder().build();
        return gameRepository.save(game);
    }
}
