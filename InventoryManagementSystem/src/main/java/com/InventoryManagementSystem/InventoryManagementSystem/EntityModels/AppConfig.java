package com.BillGenrationsSystem.BillManagementSystem.EntityModels;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public HalperCount halperCount() {
        return new HalperCount();
    }
}
