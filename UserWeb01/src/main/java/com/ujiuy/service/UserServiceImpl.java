package com.ujiuy.service;

import com.ujiuy.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    private String finService(){
        List<ServiceInstance> instances = discoveryClient.getInstances("USERPROVIDER");
        if(instances!=null&&instances.size()>0) {
            ServiceInstance serviceInstance = instances.get(0);

            String host = serviceInstance.getHost();
            int port = serviceInstance.getPort();
            return "http://"+host+":"+port;
        }
        return null;
        }


    @Override
    public Map finAll() {
        return restTemplate.getForObject(finService()+"/", Map.class);

    }

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


