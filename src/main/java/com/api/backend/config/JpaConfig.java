package com.api.backend.config;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class JpaConfig {

    private final ApplicationContext applicationContext;
    private final EntityManager entityManager;
    
    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    } 

    @Bean
    public ResourcePatternResolver resourcePatternResolver() {
        return ResourcePatternUtils.getResourcePatternResolver(applicationContext);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            DataSource dataSource,
            ResourcePatternResolver resourcePatternResolver
    ) {
        Resource[] resources;
        try {
            resources = resourcePatternResolver.getResources("classpath:META-INF/*.xml");
        } catch (IOException e) {
            throw new RuntimeException("Error while loading xml resources", e);
        }

        String[] mappingResources = Arrays.stream(resources)
                .map(this::getUrlAsString)
                .toArray(String[]::new);

        return builder
                .dataSource(dataSource)
                .packages("com.api.backend.entity")
                .persistenceUnit("myPersistence")
                .mappingResources(mappingResources)
                .build();
    }

    private String getUrlAsString(Resource resource) {
        try {
            URL url = resource.getURL();
            return url.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error while getting URL from resource", e);
        }
    }

}