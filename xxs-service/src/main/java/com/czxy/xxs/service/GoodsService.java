package com.czxy.xxs.service;


import com.czxy.xxs.Dao.GoodsMapper;
import com.czxy.xxs.Dao.SpecMapper;
import com.czxy.xxs.pojo.Goods;
import com.czxy.xxs.pojo.SpecList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private SpecMapper specMapper;

    //查询商品详情
    public Goods findById(Integer cid){
        //通过mapper，根据cid查询数据
        Goods goods=this.goodsMapper.findById(cid);

        System.out.println(goods);
        return goods;
    }


    //查询商品规格
    public List<SpecList> findAll() {

        List<SpecList> list = this.specMapper.findSpecListByCategoryId();
        System.out.println(list);
        return list;
    }

}
