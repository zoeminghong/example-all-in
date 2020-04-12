package com.zerostech.stock.broadcast.controller;

import com.ecfront.dew.common.Resp;
import com.zerostech.stock.broadcast.CommonConstants;
import com.zerostech.stock.broadcast.dto.StockTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020-03-19.
 *
 * @author 迹_Jason
 */
@RestController
@RequestMapping
public class TokenController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @PutMapping("refresh/token")
    public Resp<Void> refreshToken(@RequestBody StockTokenDTO token) {
        redisTemplate.opsForValue().set(CommonConstants.RedisKey.TOKEN_KEY,token.getToken());
        return Resp.success(null);
    }
}
