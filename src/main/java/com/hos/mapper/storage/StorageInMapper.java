package com.hos.mapper.storage;

import com.hos.entity.StroageIn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xu
 * @date 19/10/29-9:23
 */
@Mapper
public interface StorageInMapper {

    public List<StroageIn> query();
}
