package com.hos.controller;

import com.hos.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SellerService sellerService;

    @GetMapping({"/home", "/", ""})
    public String home() {
        return "welcome";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/addSeller")
    @ResponseBody
    public int signUp(@RequestBody Map<String, Object> params) {
        return sellerService.register(params);
    }

    @PostMapping("/login")
    @ResponseBody
    public int login(@RequestBody Map<String, Object> params, HttpSession session) {
        String sellerId = (String) params.get("id");
        String password = (String) params.get("password");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(sellerId, password);
        try {
            //使用SpringSecurity拦截登陆请求 进行认证和授权
            Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            //使用redis session共享
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @PostMapping("/register")
    @ResponseBody
    public int register(@RequestBody Map<String, Object> params) {
        return sellerService.register(params);
    }
}