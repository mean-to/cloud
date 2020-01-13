package com.ujiuy;

import com.ujiuy.Filter.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy
@SpringCloudApplication

public class ZuulStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulStartApplication.class,args);
    }
    @Bean
    public Filter getFileter(){
        return new Filter();
    }
}

