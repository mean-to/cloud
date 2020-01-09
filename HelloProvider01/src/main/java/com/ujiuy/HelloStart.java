package com.ujiuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloStart {
    public static void main(String[] args) {
        SpringApplication.run(HelloStart.class,args);
    }
}
