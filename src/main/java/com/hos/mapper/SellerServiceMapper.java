package com.hos.mapper;

import com.hos.entity.Seller;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface SellerServiceMapper {
    Seller getSellerById(String id);
    int register(@Param(value = "params") Map<String,Object> params);
}
