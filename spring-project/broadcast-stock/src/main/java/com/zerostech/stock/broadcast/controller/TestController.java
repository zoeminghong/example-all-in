package com.zerostech.stock.broadcast.controller;

import com.ecfront.dew.common.Resp;
import com.zerostech.stock.broadcast.service.SelectStockTimerBroadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020-03-19.
 *
 * @author 迹_Jason
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private SelectStockTimerBroadcast selectStockTimerBroadcast;

    @GetMapping
    public Resp<Void> test() {
        selectStockTimerBroadcast.query();
        return Resp.success(null);
    }
}
