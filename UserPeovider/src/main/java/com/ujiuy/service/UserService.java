package com.ujiuy.service;

import com.ujiuy.po.User;

import java.util.List;

public interface UserService {
    public List<User> finAll();
    public User findOne(Long id);
    public void update(User user);
    public void delete(Long id);
    public void add(User user);
}
