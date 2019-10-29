package com.hos.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author Peng
 * @Date 2019\10\29 0029 15:03
 **/
@Data
public class SystemLogger {
    private Date visitTime;
    private int user_id;
    private String ip;
    private String url;
    private String className;
    private String methodName;
    private String args;
    private long excutionTime;
}
