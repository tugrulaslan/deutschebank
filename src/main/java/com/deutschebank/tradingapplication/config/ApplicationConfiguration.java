package com.deutschebank.tradingapplication.config;

import com.deutschebank.tradingapplication.service.downstreamservice.Algo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Algo algo(){
        return new Algo();
    }
}
