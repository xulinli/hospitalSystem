package com.hos.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author Peng
 * @Date 2019\10\28 0028 9:35
 **/
/*  病人基本信息表(挂号单) */
@Data
public class PatientsInfo {
    private int register_id;            //挂号编号
//    private Hospital hospital;          //医院
    private RegisterType registerType;  //挂号类型编号
    private String patients_name;       //病人姓名
    private String patients_sex;        //病人性别
    private int patients_age;           //病人年龄
    private Date register_time;         //挂号日期
    private Registrar registrar;        //挂号员id
}
