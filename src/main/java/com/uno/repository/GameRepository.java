package com.uno.repository;

import com.uno.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Game save(Game game) {
        return mongoTemplate.save(game);
    }
}
