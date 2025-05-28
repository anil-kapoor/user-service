package com.example.userservice.config;

import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.CosmosFactory;
import com.azure.spring.data.cosmos.config.CosmosConfig;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCosmosRepositories(basePackages = "com.example.userservice.repository")
public class CosmosConfiguration extends AbstractCosmosConfiguration {

    @Value("${azure.cosmos.uri}")
    private String uri;

    @Value("${azure.cosmos.key}")
    private String key;

    @Value("${azure.cosmos.database}")
    private String database;

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Bean
    public CosmosAsyncClient cosmosAsyncClient() {
        return new CosmosClientBuilder()
                .endpoint(uri)
                .key(key)
                .buildAsyncClient();
    }

    @Bean
    public CosmosFactory cosmosFactory(CosmosAsyncClient cosmosAsyncClient) {
        return new CosmosFactory(cosmosAsyncClient, database);
    }

    @Bean
    public CosmosConfig cosmosConfig() {
        return CosmosConfig.builder()
                .enableQueryMetrics(true)
                .build();
    }
}
