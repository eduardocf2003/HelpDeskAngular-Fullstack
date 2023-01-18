package br.com.mesttra.helpdeskangular.config;

import br.com.mesttra.helpdeskangular.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaDB() {
        dbService.instanciaDB();
    }

}
