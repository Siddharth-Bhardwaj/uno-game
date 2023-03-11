package com.uno.service;

import com.uno.dtos.game.GameRequest;
import com.uno.model.Game;

public interface GameService {
    Game createGame(GameRequest gameRequest);

    Game getGame(String gameId);

    Game startGame(String gameId, String playerId);
}
