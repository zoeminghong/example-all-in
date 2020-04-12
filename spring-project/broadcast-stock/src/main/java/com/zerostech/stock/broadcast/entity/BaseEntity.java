package com.zerostech.stock.broadcast.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2020-03-31.
 *
 * @author 迹_Jason
 */
public class BaseEntity implements Serializable {

    private String createBy;
    private String updateBy;
    private Date createDate;
    private Date updateDate;
}
