package com.czxy.xxs.service;

import com.czxy.xxs.client.CartMapper;

import com.czxy.xxs.pojo.Cart;
import com.czxy.xxs.pojo.SpecList;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service

public class CartService {

    @Resource
    private CartMapper cartMapper;

    //添加购物车
    public void addCart(Cart cart){
        cart.setCartChecked(true);
        cart.setCount(1);
        Cart c=cartMapper.findById(cart.getCid());
//        System.out.println(c);
        if(c!=null){
            if(cart.getId().equals(c.getId())){
                Integer i=c.getCount()+1;
                c.setCount(i);
                System.out.println(c.getCount());
                this.cartMapper.updateByPrimaryKey(c);
            }
        }else{
            this.cartMapper.insert(cart);
        }

    }


    //查询购物车
    public List<Cart> findAll() {

        List<Cart> list = this.cartMapper.selectAll();
//        System.out.println(list);
        return list;
    }


    //修改购物车
    public void updateCart(Cart cart){

        Cart c=cartMapper.findById(cart.getCid());
//        System.out.println(c);

            //修改数量
            Integer a=cart.getCount();
            c.setCount(a);

            //修改状态
            Boolean b=cart.getCartChecked();
            c.setCartChecked(b);

//            System.out.println("数量---------"+c.getCount());
//            System.out.println("状态---------"+c.getCartChecked());
            this.cartMapper.updateByPrimaryKey(c);


    }

    //删除购物车
    public void deleteCart(Integer cid) {
        System.out.println(cid);
        Cart c=cartMapper.findById(cid);
        this.cartMapper.delete(c);

    }

}
