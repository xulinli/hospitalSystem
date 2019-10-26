package com.hos.service.impl;

import com.hos.entity.Seller;
import com.hos.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public class YYSSellerDetailService implements UserDetailsService {

    @Autowired
    private SellerService sellerService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Seller seller = sellerService.getSellerById(s);
        if(seller == null) throw new UsernameNotFoundException("账号不存在");
        return seller;
    }
}