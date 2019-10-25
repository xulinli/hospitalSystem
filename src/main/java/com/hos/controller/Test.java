package com.hos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xu
 * @date 19/10/25-11:13
 */
@CrossOrigin
@Controller
@RequestMapping("test")
public class Test {

    @GetMapping
    public String test(){
        return "test";
    }
}
