package com.hos.entity;

import lombok.Data;

/**
 * 药品入库
 * @author xu
 * @date 19/10/26-17:13
 */
@Data
public class StrorageIn {
    private long id ;
    private String name;
    private Integer number;
    private String  supplier;//供货商
    private String action; //操作员
    private String inTime; //

}
