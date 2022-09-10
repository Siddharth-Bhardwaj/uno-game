package com.uno.service;

import com.uno.dtos.player.Player;
import com.uno.model.Game;

public interface PlayerService {

    Player create(String name);

    Game joinGame(String playerName, String gameId);

    Game leaveGame(String playerId, String gameId);

}
