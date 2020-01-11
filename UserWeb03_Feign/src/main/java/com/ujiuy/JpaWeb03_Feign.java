package com.ujiuy;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletRegistration;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class JpaWeb03_Feign {

    public static void main(String[] args) {
        SpringApplication.run(JpaWeb03_Feign.class, args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate create(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        return  new RestTemplate();
    }
@Bean
    public ServletRegistrationBean getServlet(){
    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
    ServletRegistrationBean RegistrationBean = new ServletRegistrationBean(streamServlet);
    RegistrationBean.setLoadOnStartup(1);
    RegistrationBean.setName("HystrixMetricsStreamServle");
    RegistrationBean.addUrlMappings("/hystrix.stream");
    return RegistrationBean;
}
}

