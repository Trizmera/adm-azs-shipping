package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ADM_AZS_SHIPPING
 * Author: Trizmera
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.domain.service"})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

    }
}
