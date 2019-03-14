package com.czxy.xxs.service;


import com.czxy.xxs.Dao.AshopMapper;
import com.czxy.xxs.Dao.ShopMapper;
import com.czxy.xxs.pojo.Ashop;
import com.czxy.xxs.pojo.Shop;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ShopService {

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private AshopMapper ashopMapper;


    //商品信息查询
    public List<Shop> findShop(){

        Example example=new Example(Shop.class);

        List<Shop> list= this.shopMapper.selectByExample(example);

        return list;
    }

    //活动商品信息查询
    public List<Ashop> findAShop(){

        Example example=new Example(Ashop.class);

        List<Ashop> list= this.ashopMapper.selectByExample(example);

        return list;
    }


}
