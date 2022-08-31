package com.uno.service;

import com.uno.dtos.game.GameRequest;
import com.uno.model.Game;

public interface GameService {
    Game create(GameRequest gameRequest);
}
