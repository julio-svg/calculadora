package com.sanitas.calculadora.config;



import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configurations {
    @Bean
    public TracerImpl tracerAPI(){
        return new TracerImpl();
    }
}
