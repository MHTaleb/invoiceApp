package com.talcorpdz.config.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.talcorpdz.domain.InfoDomain;

@Configuration
@EnableMongoRepositories(basePackages = {"com.talcorpdz.repository"})
public class MongoDBConfig extends AbstractMongoClientConfiguration{
	
	
	@Value("${spring.data.mongodb.database}")
	private String databaseName;
	
	@Value("${spring.data.mongodb.uri}")
	private String mongoUri;
	
	
	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return databaseName;
	}

	@Override
	public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(mongoUri);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
        
        return MongoClients.create(mongoClientSettings);
	}
	
	@Override
	protected String getMappingBasePackage() { 
		return InfoDomain.class.getPackageName();
	}
	
}
