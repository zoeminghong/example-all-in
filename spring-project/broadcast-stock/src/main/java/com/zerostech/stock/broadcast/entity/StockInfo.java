package com.zerostech.stock.broadcast.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 2020-03-31.
 *
 * @author 迹_Jason
 */
@Data
public class StockInfo extends BaseEntity {

    private String code;
    private String name;
    private BigDecimal buyPrice;
    private Date buyTime;
    private BigDecimal goalPrice;
}
