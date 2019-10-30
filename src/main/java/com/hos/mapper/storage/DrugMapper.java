package com.hos.mapper.storage;

import com.hos.entity.Drug;
import com.hos.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author xu
 * @date 19/10/28-9:18
 */
@Mapper
public interface DrugMapper {
    public Integer add(@Param(value = "params") Map<String, Object> params);
    public Integer update(@Param(value = "params") Map<String, Object> params);
    public Integer delete(@Param(value = "params") Map<String, Object> params);
    public List<Drug> query(@Param(value = "params") Map<String, Object> params);
    public List<Drug> queryByName(@Param(value = "params") Map<String, Object> params);
}
