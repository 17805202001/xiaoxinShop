package com.czxy.xxs.Dao;


import com.czxy.xxs.pojo.Goods;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface GoodsMapper extends Mapper<Goods> {


    @Select("select * from tb_goods where cid=#{cid}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property="cid",column="cid"),
            @Result(property="describe",column="describe"),
            @Result(property="goodsName",column="goods_name"),
            @Result(property="specList",column="spec_list"),
            @Result(property="specListCode",column="spec_list_code"),


    })
    public Goods findById(@Param("cid") Integer cid);
}
