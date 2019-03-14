package com.czxy.xxs.controller;

import com.czxy.xxs.pojo.Cart;
import com.czxy.xxs.pojo.SpecList;
import com.czxy.xxs.service.CartService;

import com.czxy.xxs.vo.BaseResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class CartController {

    @Autowired
    private CartService cartService;


    //添加购物车
    @PostMapping("/carts")
    public ResponseEntity<BaseResult> addCart(@RequestBody Cart cart) {

        cartService.addCart(cart);

        return ResponseEntity.ok( new BaseResult(0 , "成功1") );

    }


    //查询购物车
    @GetMapping("/carts")
    public ResponseEntity<BaseResult> findAll(){
        //查询所有
        List<Cart> list=this.cartService.findAll();
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",list));
    }


    //修改购物车
    @PutMapping("/carts")
    public ResponseEntity<BaseResult> updateCart(@RequestBody Cart cart) {

        cartService.updateCart(cart);

        return ResponseEntity.ok( new BaseResult(0 , "成功1") );

    }


    //删除购物车
    @DeleteMapping("/carts/{cid}")
    public ResponseEntity<BaseResult> deleteCart(@PathVariable("cid") Integer cid) {

        cartService.deleteCart(cid);

        return ResponseEntity.ok( new BaseResult(0 , "成功1") );

    }
}
