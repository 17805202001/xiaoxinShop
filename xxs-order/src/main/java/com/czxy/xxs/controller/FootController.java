package com.czxy.xxs.controller;


import com.czxy.xxs.pojo.Foot;
import com.czxy.xxs.pojo.Goods;
import com.czxy.xxs.service.FootService;
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
public class FootController {


    @Resource
    private FootService footService;


    @GetMapping("/foots/{cid}")
    public ResponseEntity<BaseResult> addFoots(@PathVariable("cid") Integer cid){


       this.footService.addById(cid);


        return ResponseEntity.ok(new BaseResult(0,"成功"));
    }


    @GetMapping("/foots")
    public ResponseEntity<BaseResult> findFoots(){


        List<Foot> list=this.footService.findById();

        int i=list.size();
        System.out.println("足迹数量："+i);
        System.out.println("list"+list);
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",list).append("footCount",i));
    }
}
