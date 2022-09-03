package com.uno.dtos.player;

import com.uno.dtos.Card;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Player {
    private String id;

    private String name;

    private List<Card> cards;

    private boolean isActive;
}
