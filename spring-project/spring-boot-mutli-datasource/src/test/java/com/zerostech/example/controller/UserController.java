package com.zerostech.example.controller;

import com.ecfront.dew.common.Resp;
import com.zerostech.example.entity.User;
import com.zerostech.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2020-03-18.
 *
 * @author 迹_Jason
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Resp<List<User>> getUser() {
        return Resp.success(userService.getList());
    }
}
