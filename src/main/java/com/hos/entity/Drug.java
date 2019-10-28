package com.hos.entity;

import lombok.Data;

/**
 * 药品详情单
 * @author xu
 * @date 19/10/26-16:05
 */
@Data
public class Drug {
    private long id;
    private String name;
    private String pro;//生产单位
    private Double price;
    private String spec;
}
