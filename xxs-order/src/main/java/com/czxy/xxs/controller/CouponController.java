package com.czxy.xxs.controller;


import com.czxy.xxs.pojo.Coupon;
import com.czxy.xxs.service.CouponService;
import com.czxy.xxs.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping
public class CouponController {


    @Resource
    private CouponService couponService;


    @GetMapping("/coupons")
    public ResponseEntity<BaseResult> findAll(){

        List<Coupon> list=this.couponService.findAll();
        System.out.println(list);
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",list));
    }
}
