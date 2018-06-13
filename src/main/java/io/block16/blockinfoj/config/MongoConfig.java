package io.block16.blockinfoj.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongo.location:18.220.141.134}")
    public String mongoLocation;

    @Value("${mongo.port:27017}")
    public int mongoPort;

    @Override
    protected String getDatabaseName() {
        return "blockstorage";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(mongoLocation, mongoPort);
    }
}