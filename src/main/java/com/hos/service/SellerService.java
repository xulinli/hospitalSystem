package com.hos.service;

import com.hos.entity.Seller;

import java.util.Map;

public interface SellerService {
    Seller getSellerById(String id);
    int register(Map<String, Object> params);
}
