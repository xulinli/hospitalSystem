package com.hos.entity;

import lombok.Data;

/**
 * 分类详情
 * @author xu
 * @date 19/10/26-16:21
 */
@Data
public class Brand {
    private long id;
    private String name;
    private long parentId;
}
