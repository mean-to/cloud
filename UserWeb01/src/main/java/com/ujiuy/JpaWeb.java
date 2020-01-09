package com.ujiuy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class JpaWeb {

    public static void main(String[] args) {
        SpringApplication.run(JpaWeb.class, args);
    }
    @Bean
    public RestTemplate create(){
        return  new RestTemplate();
    }

}

