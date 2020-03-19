package com.zerostech.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zerostech.example.entity.User;

import java.util.List;

/**
 * Created on 2020-03-18.
 *
 * @author 迹_Jason
 */
public interface UserDao extends BaseMapper<User> {

    List<User> getList();
}
