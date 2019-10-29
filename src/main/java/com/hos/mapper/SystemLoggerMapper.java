package com.hos.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * @Author Peng
 * @Date 2019\10\29 0029 16:10
 **/
@Mapper
public interface SystemLoggerMapper {
    int addLog(int user_id, String ip, String url, String className, String methodName, String args, long excutionTime);
}
