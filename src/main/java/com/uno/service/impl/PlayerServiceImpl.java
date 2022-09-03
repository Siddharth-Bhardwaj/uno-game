package com.uno.service.impl;

import com.uno.dtos.player.Player;
import com.uno.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    @Override
    public Player create(String name) {
        return Player.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .isActive(true)
                .build();
    }
}
