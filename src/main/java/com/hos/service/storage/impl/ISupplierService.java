package com.hos.service.storage.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hos.entity.Supplier;
import com.hos.mapper.storage.SuppllierMapper;
import com.hos.service.storage.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author xu
 * @date 19/10/28-9:16
 */
@Service
public class ISupplierService implements SupplierService {

    @Autowired
    private SuppllierMapper suppllierMapper;

    @Override
    public Integer add(Map<String, Object> params) {
        String name = (String) params.get("name");
        if(StringUtils.isEmpty(name)) return -1;
        String tel = (String) params.get("tel");
        if(StringUtils.isEmpty(tel)) return -1;
        return suppllierMapper.add(params);
    }

    @Override
    public Integer update(Map<String, Object> params) {
        String name = (String) params.get("name");
        if(StringUtils.isEmpty(name)) return -1;
        return suppllierMapper.update(params);
    }

    @Override
    public Integer delete(Map<String, Object> params) {
        boolean delall = Boolean.valueOf((String) params.get("delall")) ;
        if(delall) {//全选，一定要包含关键字
            String keyname = (String) params.get("keyname");
            if(StringUtils.isEmpty(keyname)) return -1;
        }else {
            String name = (String) params.remove("name");
            if(StringUtils.isEmpty(name)) return -1;
            String names= null;
            try {
                names = new String(name.getBytes("ISO-8859-1"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            params.put("name",names);
        }
        return suppllierMapper.delete(params);
    }

    @Override
    public PageInfo<Supplier> query(Map<String, Object> params) {
        int currentPage = Integer.parseInt((String) params.remove("currentPage"));
        int displayCount = Integer.parseInt((String) params.remove("displayCount"));
        String keyname= null;
        try {
            keyname = new String(((String) params.remove("keyname")).getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(keyname);
        params.put("keyname",keyname);
        PageHelper.startPage(currentPage, displayCount);
        return new PageInfo<Supplier>(suppllierMapper.query(params));
    }
}
