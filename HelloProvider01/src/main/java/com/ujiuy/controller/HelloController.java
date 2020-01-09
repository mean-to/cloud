package com.ujiuy.controller;


import com.ujiuy.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
   HelloService helloService;
    @GetMapping("/hello")
public String sayHello(){
      return   helloService.sayHello();
    }
}
