package com.czxy.xxs.controller;


import com.czxy.xxs.pojo.Seckill;

import com.czxy.xxs.service.SeckillService;
import com.czxy.xxs.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping
public class SeckillController {


    @Resource
    private SeckillService seckillService;


    //商品秒杀
    @GetMapping("/shops")
    public ResponseEntity<BaseResult> seckillShop(){

        List<Seckill> list=this.seckillService.seckillShop();

        //2 封装
        BaseResult baseResult = new BaseResult(0,"成功")
                .append("data" , list);
        return ResponseEntity.ok( baseResult );
    }


    //秒杀商品状态修改
    @PutMapping("/shops")
    public ResponseEntity<BaseResult> updateShop(@RequestBody Seckill seckill) throws Exception {
        System.out.println("seckill:"+seckill);
        this.seckillService.updateShop(seckill);

        return ResponseEntity.ok( new BaseResult(0 , "成功1") );
    }
}
