package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "junior")
    public Programmer juniorProgrammer() {
        return new Junior();
    }

    @Bean(name = "middle")
    public Programmer middleProgrammer() {
        return new Middle();
    }

    @Bean(name = "senior")
    public Programmer seniorProgrammer() {
        return new Senior();
    }
}

