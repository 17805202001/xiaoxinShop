package com.czxy.xxs.controller;


import com.czxy.xxs.pojo.Goods;
import com.czxy.xxs.pojo.SpecList;
import com.czxy.xxs.service.GoodsService;
import com.czxy.xxs.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping
public class GoodsController {


    @Resource
    private GoodsService goodsService;

    //查询商品详情
    @GetMapping("/goods/{cid}")
    public ResponseEntity<Goods> findById(@PathVariable("cid") Integer cid){
        System.out.println(cid);
        Goods goods=this.goodsService.findById(cid);

        return ResponseEntity.ok(goods);


    }


    //查询商品信息
    @GetMapping("/spec")
    public ResponseEntity<BaseResult> findAll(){
        //查询所有
        List<SpecList> list=this.goodsService.findAll();
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",list));
    }
}
