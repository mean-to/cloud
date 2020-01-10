package com.ujiuy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
//允许熔断器器生效
@EnableCircuitBreaker
public class JpaWeb02 {
    public static void main(String[] args) {
        SpringApplication.run(JpaWeb02.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate create(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        //读取超时
        factory.setReadTimeout(250);
        //连接超时
        factory.setConnectTimeout(250);
        return  new RestTemplate(factory);
    }

}

