package com.ujiuy.service;

import com.ujiuy.FeiGnConfig;
import com.ujiuy.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@FeignClient(value = "ZUUL",configuration = FeiGnConfig.class,fallback = UserServiceImpl.class)
public interface UserService {
@GetMapping("/userprovider?accessToken=44")
    public Map finAll();
@GetMapping("/userprovider/toEdit/{id}")
    public User findOne(@PathVariable Long id);
@PutMapping ("/userprovider/update")
    public void update(User user);
@DeleteMapping("/userprovider/delete/{id}")
    public void delete(@PathVariable Long id);
@PostMapping("/userprovider/add")
    public void add(User user);
}
