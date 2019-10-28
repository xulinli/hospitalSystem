package com.hos.service.impl;

import com.hos.entity.Seller;
import com.hos.mapper.SellerServiceMapper;
import com.hos.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerServiceMapper sellerServiceMapper;

    @Override
    public Seller getSellerById(String id) {
        return sellerServiceMapper.getSellerById(id);
    }

    @Override
    public int register(Map<String, Object> params) {
        String id = (String) params.get("sellerId");
        Seller seller =  sellerServiceMapper.getSellerById(id);
        if(seller!=null){
            return -1;
        }
        String password = (String) params.get("password");
        BCryptPasswordEncoder jiami = new BCryptPasswordEncoder();
        password = jiami.encode(password);
        params.put("password",password);
        SimpleDateFormat data = new SimpleDateFormat("yyyy/MM/dd HH/mm/ss");
        String data1 = data.format(new Date());
        params.put("data",data1);
        return sellerServiceMapper.register(params);
    }
}
