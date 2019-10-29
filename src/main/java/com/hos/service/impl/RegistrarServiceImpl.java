package com.hos.service.impl;

import com.hos.entity.PatientsInfo;
import com.hos.entity.Registrar;
import com.hos.mapper.RegisterMapper;
import com.hos.service.RegistrarService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Author Peng
 * @Date 2019\10\28 0028 16:13
 **/
@Service
public class RegistrarServiceImpl implements RegistrarService {

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public int queryRegistrarById(Map<String, Object> params) {
//        params.put("register_id",1001);
//        params.put("password","123456");
        Registrar registrar=registerMapper.queryRegistrarById(params);
        if(registrar==null) return -1;
        String password= (String) params.get("password");
        if(!password.equals(registrar.getPassword())) return 0;
        return 1;
    }

    @Override
    public int updatePassword(Map<String, Object> params) {
        return 0;
    }

    @Override
    public int addPatientsInfo(Map<String, Object> params) {
        return 0;
    }

    @Override
    public List<PatientsInfo> queryPatientsInfo(Map<String, Object> params) {
        return null;
    }

    @Override
    public int deletePatientsInfo(Map<String, Object> params) {
        return 0;
    }

    @Override
    public int logout() {
        return 0;
    }

    @Override
    public int close() {
        return 0;
    }
}
