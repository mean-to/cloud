package com.ujiuy.service;

import com.ujiuy.dao.UserDao;
import com.ujiuy.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> finAll() {
        List<User> ulist = userDao.findAll();
        return ulist;
    }

    @Override
    public User findOne(Long id) {
        User user = userDao.findById(id).get();
        return user;
    }

    @Override
    public void update(User user) {
        userDao.saveAndFlush(user);

    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);

    }

    @Override
    public void add(User user) {
        userDao.save(user);

    }
}
