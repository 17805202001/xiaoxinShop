package com.czxy.xxs.service;


import com.czxy.xxs.client.UserClient;
import com.czxy.xxs.config.JwtProperties;
import com.czxy.xxs.entiy.UserInfo;
import com.czxy.xxs.pojo.User;
import com.czxy.xxs.util.JwtUtils;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthService {

    @Resource
    private UserClient userClient;

    @Resource
    private JwtProperties jwtProperties;

    /**
     * 登录操作
     * @param mobile  手机号
     * @param password 密码
     * @return  token值
     */
    public User login(String mobile , String password){
        try {
            //1 登录--查询
            User user = userClient.queryUser( mobile ,password ).getBody();

            //2 如果不为空，生产token
            if(user != null){

                return user;
            }
            //3 如果为空
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;        //没有登录成功
    }


}

