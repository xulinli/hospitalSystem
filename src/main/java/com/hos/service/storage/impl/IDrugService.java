package com.hos.service.storage.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hos.entity.Drug;
import com.hos.entity.Supplier;
import com.hos.mapper.storage.DrugMapper;
import com.hos.service.storage.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xu
 * @date 19/10/28-15:59
 */
@Service
public class IDrugService implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public Integer add(Map<String, Object> params) {
        //判断每个字段是否为空，因为数据库不能为空
        String name = (String) params.get("name");
        Integer pro = (Integer) params.get("pro");
        String price = (String) params.get("price");
        Integer spec = (Integer) params.get("spec");
        if (StringUtils.isEmpty(name) || pro <= 0 || StringUtils.isEmpty(price) || spec <= 0) return -1;
        //查询当前的名字是否存在
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("keyname", name);
        List<Drug> name1 = drugMapper.query(objectObjectHashMap);
        if (name1.size() != 0) return -1;
        return drugMapper.add(params);
    }

    @Override
    public Integer update(Map<String, Object> params) {
        String name = (String) params.get("name");
        if (StringUtils.isEmpty(name)) return -1;
        //价格不能小于0
        Object price = params.get("price");
        if (price != null && (double) price <= 0) return -1;
        return drugMapper.update(params);
    }

    @Override
    public Integer delete(Map<String, Object> params) {
        boolean delall = Boolean.valueOf((String) params.get("delall"));
        if (delall) {//全选，一定要包含关键字
            String keyname = (String) params.get("keyname");
            if (StringUtils.isEmpty(keyname)) return -1;
        } else {
            String name = (String) params.remove("name");
            if (StringUtils.isEmpty(name)) return -1;
            String names = null;
            try {
                names = new String(name.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            params.put("name", names);
        }
        return drugMapper.delete(params);
    }

    @Override
    public PageInfo<Drug> query(Map<String, Object> params) {
        int currentPage = Integer.parseInt((String) params.remove("currentPage"));
        int displayCount = Integer.parseInt((String) params.remove("displayCount"));
        String keyname = null;
        try {
            keyname = new String(((String) params.remove("keyname")).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(keyname);
        params.put("keyname", keyname);
        PageHelper.startPage(currentPage, displayCount);
        List<Drug> query = drugMapper.query(params);
        return new PageInfo<Drug>(query);
    }
}
