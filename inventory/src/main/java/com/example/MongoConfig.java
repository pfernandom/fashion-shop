package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.repository")
public class MongoConfig extends AbstractMongoConfiguration {
  
    @Override
    protected String getDatabaseName() {
        return "test";
    }
  
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("mongo", 27017);
    }
  
    @Override
    protected String getMappingBasePackage() {
        return "org.pfernandom";
    }
}