package com.hos.service.storage.impl;

import com.hos.entity.StroageIn;
import com.hos.mapper.storage.StorageInMapper;
import com.hos.service.storage.StorageInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xu
 * @date 19/10/29-9:22
 */
@Service
public class IStorageInService implements StorageInService {

    @Autowired
    private StorageInMapper storageInMapper;

    @Override
    public List<StroageIn> query() {
        List<StroageIn> query = storageInMapper.query();
        for(int i=0;i<10;i++){
            query.add(query.get(0));
        }
        return query;
    }
}
