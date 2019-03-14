package com.czxy.xxs.controller;


import com.czxy.xxs.pojo.Address;
import com.czxy.xxs.pojo.Cart;
import com.czxy.xxs.pojo.Order;
import com.czxy.xxs.service.OrderService;
import com.czxy.xxs.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping
public class OrderController {

    @Resource
    private OrderService orderService;



    //查询所购商品信息
    @GetMapping("/orders/{oid}")
    public ResponseEntity<BaseResult> findAll(@PathVariable("oid") Integer oid){
        //查询所有
        Cart cart=this.orderService.findAll(oid);
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",cart));
    }


    //生成订单
    @PostMapping("/orders")
    public ResponseEntity<BaseResult> addOrder(@RequestBody Order order) {
       // System.out.println(order);
        orderService.addOrder(order);

        return ResponseEntity.ok( new BaseResult(0 , "成功1") );

    }


    //查询订单状态
    @GetMapping("/ordersList")
    public ResponseEntity<BaseResult> findAllOrder(){
        //查询所有
        List<Order> list=this.orderService.findAllOrder();
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",list));
    }


    //删除订单
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<BaseResult> deleteAddress(@PathVariable("id") Integer id) {
       // System.out.println("订单id"+id);
        orderService.deleteOrder(id);

        return ResponseEntity.ok( new BaseResult(0 , "删除成功1") );

    }

    //修改订单状态
    @PutMapping("/orders")
    public ResponseEntity<BaseResult> updateOrders(@RequestBody Order order) {

        orderService.updateOrders(order);

        return ResponseEntity.ok( new BaseResult(0 , "成功1") );

    }


}
