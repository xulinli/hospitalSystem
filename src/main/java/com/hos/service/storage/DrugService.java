package com.hos.service.storage;

import com.github.pagehelper.PageInfo;
import com.hos.entity.Drug;
import com.hos.entity.Supplier;

import java.util.Map;

/**
 * @author xu
 * @date 19/10/28-9:14
 */
public interface DrugService {
    public Integer add(Map<String, Object> params);
    public Integer update(Map<String, Object> params);
    public Integer delete(Map<String, Object> params);
    public PageInfo<Drug> query(Map<String, Object> params);

}
