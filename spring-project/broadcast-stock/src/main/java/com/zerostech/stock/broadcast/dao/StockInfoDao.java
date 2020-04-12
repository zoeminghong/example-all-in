package com.zerostech.stock.broadcast.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zerostech.stock.broadcast.entity.StockInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created on 2020-03-31.
 *
 * @author 迹_Jason
 */
@Mapper
public interface StockInfoDao extends BaseMapper<StockInfo> {
}
