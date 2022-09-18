package com.uno.config;

import com.mongodb.WriteConcern;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoConfig {

    @Primary
    @Bean(name = "unoMongoProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb")
    MongoProperties getUnoMongoConfig() {
        return new MongoProperties();
    }

    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate() {
        MongoDatabaseFactory mongoDatabaseFactory = new SimpleMongoClientDatabaseFactory(getUnoMongoConfig().getUri());
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDatabaseFactory);
        MappingMongoConverter mongoMapping = (MappingMongoConverter) mongoTemplate.getConverter();
        mongoMapping.setMapKeyDotReplacement("#");
        mongoMapping.afterPropertiesSet();
        mongoTemplate.setWriteConcern(WriteConcern.MAJORITY);
        return mongoTemplate;
    }

}
