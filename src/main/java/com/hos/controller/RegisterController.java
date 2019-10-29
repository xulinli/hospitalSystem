package com.hos.controller;

import com.hos.service.RegistrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author Peng
 * @Date 2019\10\28 0028 16:32
 **/
@RestController
@RequestMapping("registrar")
public class RegisterController {

    @Autowired
    private RegistrarService registrarService;

    @GetMapping
    public int login(@RequestParam Map<String,Object> params){
        int registrar=registrarService.queryRegistrarById(params);
        return registrar;
    }
}
