package com.hos.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author Peng
 * @Date 2019\10\28 0028 9:50
 **/
/*  收费项目表 */
@Data
public class ChargeItem {
    private int charge_type_id;         //收费项目编号
    private String charge_name;         //收费名称
    private PatientsInfo patientsInfo;  //挂号编号(病人编号)
    private Date charge_time;           //收费日期
    private float charge_price;         //收费金额
    private int status;                 //收费状态,默认为0未收费,1为已收费
    private Toll toll;                  //收费员id
}
