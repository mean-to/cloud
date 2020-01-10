package com.ujiuy.service;

import com.ujiuy.FeiGnConfig;
import com.ujiuy.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@FeignClient(value = "USERPROVIDER",configuration = FeiGnConfig.class,fallback = UserServiceImpl.class)
public interface UserService {
@GetMapping("/")
    public Map finAll();
@GetMapping("/toEdit/{id}")
    public User findOne(@PathVariable Long id);
@PutMapping ("/update")
    public void update(User user);
@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id);
@PostMapping("/add")
    public void add(User user);
}
