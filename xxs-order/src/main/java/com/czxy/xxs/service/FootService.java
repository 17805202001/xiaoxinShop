package com.czxy.xxs.service;


import com.alibaba.fastjson.JSON;
import com.czxy.xxs.dao.FootClient;
import com.czxy.xxs.dao.FootMapper;
import com.czxy.xxs.pojo.Foot;
import com.czxy.xxs.pojo.Goods;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class FootService {


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private FootMapper footMapper;

    @Resource
    private FootClient footClient;

    //查询商品详情
    public void addById(Integer cid){
        //根据cid查询数据
        ResponseEntity<Goods> foots=this.footClient.findByCid(cid);

        Goods f=foots.getBody();
        System.out.println("goods:"+f);

        Foot foot=new Foot();
        foot.setGid(f.getCid());
        foot.setGoodsName(f.getGoodsName());
        foot.setPrice(f.getPrice());
        foot.setOldPrice(f.getPrices());
        foot.setImages(f.getImages());

        this.footMapper.insert(foot);

    }


    //查询商品详情
    public List<Foot> findById(){

        List<Foot> list=this.footMapper.selectAll();

        return list;
    }
}
