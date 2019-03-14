package com.czxy.xxs.controller;

import com.czxy.xxs.config.JwtProperties;
import com.czxy.xxs.entiy.UserInfo;
import com.czxy.xxs.pojo.User;
import com.czxy.xxs.service.AuthService;
import com.czxy.xxs.util.JwtUtils;
import com.czxy.xxs.vo.BaseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class AuthController {

    @Resource
    private AuthService authService;

    @Resource
    private JwtProperties jwtProperties;


    @PostMapping("/login")
    public ResponseEntity<BaseResult> login(@RequestBody User user){

        //1登录操作--获得token

        User u=this.authService.login(user.getMobile() ,user.getPassword() );

        String token=JwtUtils.generateToken(new UserInfo( user.getId() ,user.getName() ) , jwtProperties.getPrivateKey() ,  jwtProperties.getExpire() );

//        System.out.println(token+"12345678");
        //2 有token，返回
        if(StringUtils.isNotBlank( token)){
            BaseResult baseResult = new BaseResult(0 , "登录成功").append("token", token).append("name",u.getName()).append("mobile",u.getMobile());
            return ResponseEntity.ok( baseResult );
        }
        //3 没有token，失败
        return ResponseEntity.ok( new BaseResult(1 , "登录失败"));
    }

}