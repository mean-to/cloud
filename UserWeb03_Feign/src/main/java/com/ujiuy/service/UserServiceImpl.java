package com.ujiuy.service;

import com.ujiuy.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    RestTemplate restTemplate;

    private String finService(){
            return "http://USERPROVIDER";
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


