package com.hos.service;

import com.hos.entity.PatientsInfo;
import com.hos.entity.Registrar;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author Peng
 * @Date 2019\10\28 0028 16:13
 **/
public interface RegistrarService {

    //通过ID查询挂号员
    int queryRegistrarById(@Param(value = "params") Map<String,Object> params);

    //修改密码
    int updatePassword(@Param(value = "params") Map<String,Object> params);

    //录入挂号单
    int addPatientsInfo(@Param(value = "params") Map<String,Object> params);

    //查询挂号单
    List<PatientsInfo> queryPatientsInfo(@Param(value = "params") Map<String,Object> params);

    //退号
    int deletePatientsInfo(@Param(value = "params") Map<String,Object> params);

    //退出系统
    int logout();

    //结算
    int close();
}
