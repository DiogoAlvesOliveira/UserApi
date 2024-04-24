package com.diogo.vivo.config;

import com.diogo.vivo.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("Test")
public class TestConfig {

    @Autowired
    private DbService dbService;

    @Bean
    public boolean instantiateTestDatabase() {
        dbService.instantiateTestDatabase();
        return true;
    }
}
