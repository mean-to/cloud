package com.ujiuy;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//开启日志
@Configuration
public class FeiGnConfig {
    @Bean
    public Logger.Level getFeignLogging(){
        return Logger.Level.FULL;
    }
}
