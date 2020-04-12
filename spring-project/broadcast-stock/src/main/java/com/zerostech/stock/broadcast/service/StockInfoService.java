package com.zerostech.stock.broadcast.service;

import com.zerostech.stock.broadcast.dao.StockInfoDao;
import com.zerostech.stock.broadcast.entity.StockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2020-03-31.
 *
 * @author 迹_Jason
 */
@Service
public class StockInfoService {

    @Autowired
    private StockInfoDao stockInfoDao;


    public List<StockInfo> getStockInfo() {
        return stockInfoDao.selectList(null);
    }
}
