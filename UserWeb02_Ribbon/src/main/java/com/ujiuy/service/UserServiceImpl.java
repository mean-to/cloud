package com.ujiuy.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ujiuy.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    RestTemplate restTemplate;

    private String finService(){
            return "http://USERPROVIDER";
        }



    @Override
    @HystrixCommand(fallbackMethod = "filldAllCallBack")
    public Map finAll() {
        return restTemplate.getForObject(finService()+"/", Map.class);

    }
    //熔断触发
    public Map filldAllCallBack(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("ulist",new ArrayList<>());
        map.put("version","熔断器发生熔断远程调用失败");
    return map;}

    @Override
    public User findOne(Long id) {
      return  restTemplate.getForObject(finService()+"/toEdit/"+id,User.class);

    }

    @Override
    public void update(User user) {
        restTemplate.put(finService() + "/update/", user);
        System.out.println("修改");
    }

    @Override
    public void delete(Long id) {
restTemplate.delete(finService()+"/delete/"+id);
        System.out.println("删除");
    }

    @Override
    public void add(User user) {
        String s = restTemplate.postForObject(finService() + "/add/",user, String.class);
        System.out.println("添加");
    }
}


