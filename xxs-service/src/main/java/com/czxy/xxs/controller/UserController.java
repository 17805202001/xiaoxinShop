package com.czxy.xxs.controller;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

import com.czxy.xxs.pojo.User;
import com.czxy.xxs.service.UserService;

import com.czxy.xxs.utils.SmsUtil;
import com.czxy.xxs.vo.BaseResult;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aliyuncs.exceptions.ClientException;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping
public class UserController {


    @Autowired
    private UserService userService;

    @Resource
    private StringRedisTemplate redisTemplate;


    //注册
    @PostMapping("/regist")
    public ResponseEntity<Object> regist(@RequestBody User user) {

        userService.regist(user);

        return ResponseEntity.ok(new BaseResult(0, "注册成功"));
    }


    //发送短信
    @PostMapping("/sms")
    public ResponseEntity<BaseResult> sendSms(@RequestBody User user) {
        try {
            //发送短信
            //1 生产验证码
            String code = RandomStringUtils.randomNumeric(4);

            //TODO 2 并存放到reids中
            redisTemplate.opsForValue().set(user.getMobile(), code, 1, TimeUnit.HOURS);

            //3 发送短信
            SmsUtil.sendSms(user.getMobile(), "客户", code, "", "");

            return ResponseEntity.ok(new BaseResult(0, "发送成功"));
        } catch (ClientException e) {
            e.printStackTrace();
            return ResponseEntity.ok(new BaseResult(1, "发送失败"));
        }

    }
        /**
         * 通过手机号和密码进行查询
         * @param mobile
         * @param password
         * @return
         */
        @GetMapping("/query")
        public ResponseEntity<User> queryUser(@RequestParam("mobile") String mobile , @RequestParam("password") String password){
            //1 通过手机号查询用户
            User user = this.userService.findByMobile( mobile );
            System.out.println("user"+user);
            //2 判断密码是否正确
            if(user == null || !user.getPassword().equals(password)){
                //密码不对
                return ResponseEntity.ok( null );
            }
            //3 正确
            return ResponseEntity.ok( user );
        }

}

