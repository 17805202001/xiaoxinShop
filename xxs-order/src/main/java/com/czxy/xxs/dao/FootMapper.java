package com.czxy.xxs.dao;


import com.czxy.xxs.pojo.Foot;
import com.czxy.xxs.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface FootMapper extends Mapper<Foot> {

    @Select("select * from tb_foot where gid=#{cid}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property="gid",column="gid"),
            @Result(property="uid",column="uid"),
            @Result(property="price",column="price"),
            @Result(property="oldPrice",column="old_price"),
            @Result(property="goodsName",column="goods_name"),
            @Result(property="images",column="images"),



    })
    public List<Foot> findById(@Param("cid") Integer cid);
}
