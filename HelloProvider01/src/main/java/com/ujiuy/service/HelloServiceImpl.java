package com.ujiuy.service;

import com.ujiuy.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "hello start";
    }
}
