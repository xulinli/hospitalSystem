package com.hos.entity;

import lombok.Data;

import java.util.Date;

/**
 * 报损表单
 * @author xu
 * @date 19/10/26-16:26
 */
@Data
public class Breakage {
    private long id;
    private String name;
    private String partment;
    private String hospital;
    private Integer number;
    private String season;
    private String apply;
    private String checked;
    private Date startTime;
    private Date endTime;
    private char state;
}
