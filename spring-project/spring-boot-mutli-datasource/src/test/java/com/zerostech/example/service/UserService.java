package com.zerostech.example.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zerostech.example.dao.UserDao;
import com.zerostech.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DS("rds")
public class UserService {

    @Autowired
    private UserDao userDao;


    public List<User> getList() {
        return userDao.getList();
    }
}
