package com.ujiuy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {
    @Autowired
            //连接到注册，查找服务
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/hello")
    public String demo1(String name){
       String forObject =  restTemplate.getForObject(findService()+"/hello",String.class);
       return forObject;
    }

//根据应用名称，查找服务地址，端口等相关信息
    public String findService(){
        List<ServiceInstance> instances = discoveryClient.getInstances("HELLOPROVIDER");
        //获取第一个服务
        if(instances!=null&&instances.size()>0) {
            ServiceInstance serviceInstance = instances.get(0);
            String host = serviceInstance.getHost();
            int port = serviceInstance.getPort();
            return "http://"+host+":"+port;

        }
        return null;
        }


}
