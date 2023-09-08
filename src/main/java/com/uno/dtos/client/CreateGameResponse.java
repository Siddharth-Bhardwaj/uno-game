package com.uno.dtos.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateGameResponse {
    String gameId;
    String ownerPlayerId;
}
