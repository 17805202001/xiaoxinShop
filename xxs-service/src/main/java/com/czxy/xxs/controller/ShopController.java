package com.czxy.xxs.controller;


import com.czxy.xxs.pojo.Ashop;
import com.czxy.xxs.pojo.Shop;
import com.czxy.xxs.service.ShopService;
import com.czxy.xxs.vo.BaseResult;
import com.czxy.xxs.vo.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping
public class ShopController {

    @Resource
    private ShopService shopService;


    //活动推荐商品
    @GetMapping("/shop")
    public ResponseEntity<BaseResult> shop(){

        List<Shop> list=this.shopService.findShop();

        //2 封装
        BaseResult baseResult = new BaseResult(0,"成功")
                .append("data" , list);


        return ResponseEntity.ok( baseResult );

    }

    //促销活动

    @GetMapping("/ashop")
    public ResponseEntity<BaseResult> ashop(){

        List<Ashop> list=this.shopService.findAShop();

        //2 封装
        BaseResult baseResult = new BaseResult(0,"成功")
                .append("data" , list);


        return ResponseEntity.ok( baseResult );

    }



}
