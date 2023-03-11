package com.uno.service;

import com.uno.model.Game;

public interface PlayerService {

    Game joinGame(String playerName, String gameId);

    Game leaveGame(String playerId, String gameId);

}
