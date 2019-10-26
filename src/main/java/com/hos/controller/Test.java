package com.hos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xu
 * @date 19/10/25-11:13
 */

@Controller
@RequestMapping("test")
public class Test {

    @GetMapping("/aaa")
    public String test(){
        return "test";
    }
}
