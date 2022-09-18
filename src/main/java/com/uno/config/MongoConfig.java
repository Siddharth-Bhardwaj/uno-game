//package com.uno.config;
//
//import com.mongodb.WriteConcern;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.mongo.MongoProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.mongodb.MongoDatabaseFactory;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//
//@Slf4j
//@Configuration
//public class MongoConfig extends AbstractMongoClientConfiguration {
//
//    @Primary
//    @Bean(name = "unoMongoProperties")
//    @ConfigurationProperties(prefix = "spring.data.mongodb")
//    MongoProperties getUnoMongoConfig() {
//        return new MongoProperties();
//    }
//
//    @Bean(name = "mongoTemplate")
//    public MongoTemplate mongoTemplate() {
//        log.info("Creating mongodbfactory with uri {}", getUnoMongoConfig().getUri());
//        MongoDatabaseFactory mongoDatabaseFactory = new SimpleMongoClientDatabaseFactory(getUnoMongoConfig().getUri());
//        log.info("Created mongodbfactory");
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDatabaseFactory);
//        MappingMongoConverter mongoMapping = (MappingMongoConverter) mongoTemplate.getConverter();
//        mongoMapping.setMapKeyDotReplacement("#");
//        mongoMapping.afterPropertiesSet();
//        mongoTemplate.setWriteConcern(WriteConcern.MAJORITY);
//        return mongoTemplate;
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return "uno";
//    }
//}
