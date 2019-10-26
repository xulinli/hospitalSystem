package com.hos.entity;

import lombok.Data;

/**
 * @Author Peng
 * @Date 2019\10\26 0026 16:27
 **/
/* 挂号类型实体类 */
@Data
public class RegisterType {
    private int register_type_id;   //挂号类型编号
    private String register_type;   //挂号类型
    private float register_price;   //挂号价格
}
