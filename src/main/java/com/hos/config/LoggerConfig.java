package com.hos.config;

import com.hos.mapper.SystemLoggerMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author Peng
 * @Date 2019\10\29 0029 9:45
 **/
@Configuration
@Aspect
public class LoggerConfig {

    private Logger logger= LoggerFactory.getLogger(LoggerConfig.class);
    @Autowired
    private SystemLoggerMapper systemLoggerMapper;

    @Around(value = "execution(* com.hos.controller..*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //在切面方法里取得一个request
        HttpServletRequest request= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //取得类名
        String className=pjp.getTarget().getClass().getName();
        //取得方法名
        String methodName=pjp.getSignature().getName();
        //取得参数列表
        Object[] args=pjp.getArgs();
        request.setAttribute("user_id",123123);
        try {
            systemLoggerMapper.addLog((Integer) request.getAttribute("user_id"),request.getRemoteAddr(),"2131",className,methodName,Arrays.toString(args),122);
            Object result=pjp.proceed();
//            logger.info((user_id==null?user_id:"未知用户")+"执行了"+className+","+methodName+"()方法,参数列表:"+ Arrays.toString(args)+"返回值为:"+result+"执行地址为:"+request.getRemoteHost());
            return result;
        } catch (Throwable e) {
//            logger.info((user_id==null?user_id:"未知用户")+"执行了"+className+","+methodName+"()方法,参数列表:"+ Arrays.toString(args)+"执行地址为:"+request.getRemoteHost()+"时抛出了异常,异常信息为:"+e.getMessage());
            throw e;
        }
    }
}
