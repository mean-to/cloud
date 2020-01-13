package com.ujiuy.service;

import com.ujiuy.po.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public Map finAll() {
        System.out.println("查询操作失败，触发熔断");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("ulist",new ArrayList<>());
        map.put("version","熔断");
        return map;
    }

    @Override
    public User findOne(Long id) {
        System.out.println("触发熔断");

        return null;
    }

    @Override
    public void update(User user) {
        System.out.println("触发熔断");

    }

    @Override
    public void delete(Long id) {
        System.out.println("触发熔断");

    }

    @Override
    public void add(User user) {
        System.out.println("触发熔断");

    }
}
