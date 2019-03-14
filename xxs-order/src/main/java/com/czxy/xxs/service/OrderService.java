package com.czxy.xxs.service;


import com.czxy.xxs.client.CartMapper;

import com.czxy.xxs.dao.OrderMapper;

import com.czxy.xxs.pojo.Address;
import com.czxy.xxs.pojo.Cart;
import com.czxy.xxs.pojo.Order;

import com.czxy.xxs.utils.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private CartMapper cartMapper;


    @Resource
    private IdWorker idWorker;


    //查询购物车
    public Cart findAll(Integer oid) {
        //System.out.println(oid);
        Cart c = this.cartMapper.findById(oid);
        //System.out.println(c);
        return c;
    }


    //生成订单
    public void addOrder(Order order){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        //设置支付时间
        order.setPayTime(df.format(new Date()));

        //1.1 设置订单号
        // 生成orderId
        String sn = idWorker.nextId();
        order.setSn(sn);



        this.orderMapper.insert(order);

    }

    //查询订单状态
    public List<Order> findAllOrder() {

        List<Order> list = this.orderMapper.selectAll();
        //System.out.println(list);
        return list;
    }

    //删除订单
    public void deleteOrder(Integer id){
        Order a=orderMapper.findById(id);

        //System.out.println(a);
        this.orderMapper.delete(a);
    }



    //修改订单状态
    public void updateOrders(Order order){

        Order o= this.orderMapper.findById(order.getId());
        System.out.println(o);

        //设置状态s
        o.setStatus(1);

        this.orderMapper.updateByPrimaryKey(o);

    }



}
