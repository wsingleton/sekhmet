package dev.innov8.sekhmet.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.innov8.sekhmet.services.AsyncTransactionalExecutionStrategy;
import graphql.execution.ExecutionStrategy;

@Configuration
public class GraphQLConfig {
	
    @Bean
    public Map<String, ExecutionStrategy> executionStrategies() {
        Map<String, ExecutionStrategy> executionStrategyMap = new HashMap<>();
        executionStrategyMap.put("queryExecutionStrategy", new AsyncTransactionalExecutionStrategy());
        return executionStrategyMap;
    }

}
