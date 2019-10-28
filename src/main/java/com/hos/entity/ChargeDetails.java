package com.hos.entity;

import lombok.Data;

/**
 * @Author Peng
 * @Date 2019\10\28 0028 10:01
 **/
/*  收费明细表 */
@Data
public class ChargeDetails {
    private ChargeItem chargeItem;//收费项目编号
    private int medicine_id;      //药品编号
    private int count;            //数量
    private float price;          //价格
}
