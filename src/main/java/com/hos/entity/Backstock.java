package com.hos.entity;

import lombok.Data;

import java.util.Date;

/**
 * 退货单
 * @author xu
 * @date 19/10/26-15:59
 */
@Data
public class Backstock {
    private long id;
    private String drugName;//药品名称
    private String supplierName;//供货商名字
    private Integer number;
    private String reason;
    private Double price;
    private Date time;
}
