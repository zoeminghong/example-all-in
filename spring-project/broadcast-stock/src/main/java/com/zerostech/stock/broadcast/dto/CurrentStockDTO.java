package com.zerostech.stock.broadcast.dto;

import lombok.Data;

/**
 * Created on 2020-03-31.
 *
 * @author 迹_Jason
 */
@Data
public class CurrentStockDTO {

    private Double lastPrice;
    private Double valueDelta;
    private Double priceDelta;
    private String shortNM;
}
