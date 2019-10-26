package com.hos.config;


import com.hos.service.impl.YYSSellerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author xu
 * @date 19/10/26-15:42
 */

@Configuration
@EnableWebSecurity //启用security
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启方法权限控制
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web){
        String[] permitUrls = {
                "/favicon.ico",
                "/css/**",
                "/js/**",
                "/img/**",
                "/fonts/**",
                "/views/**",
                "/plugins/**",
                "/jQuery/**",
                "/angular/**",
                "/sui/**"
        };
        web.ignoring().antMatchers(permitUrls);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] permitUrls = {
                "/register",
                "/addSeller",
                "/login"
        };
        http.csrf().disable();//禁用csrf防御，但可能出现跨域访问引发的问题。如果不禁用，post请求将直接重定向，解决方式就是自己实现RequestMatcher
//        http.csrf().requireCsrfProtectionMatcher(myRequestMatcher);
        http.authorizeRequests() //拦截请求
                // 所有用户均可访问的资源
                .antMatchers(permitUrls).permitAll()
                // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/home").permitAll()
                .and()
                //权限拒绝的页面
                .exceptionHandling().accessDeniedPage("/403");
        http.logout().logoutSuccessUrl("/home").permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public YYSSellerDetailService yysSellerDetailService(){
        return new YYSSellerDetailService();
    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(yysSellerDetailService()).passwordEncoder(passwordEncoder());
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
