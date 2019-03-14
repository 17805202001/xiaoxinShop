package com.czxy.xxs.dao;


import com.czxy.xxs.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="web-service")
@RequestMapping
public interface FootClient {

    @GetMapping("/goods/{cid}")
    public ResponseEntity<Goods> findByCid(@PathVariable("cid") Integer cid);
}
