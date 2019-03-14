package com.czxy.xxs.client;


import com.czxy.xxs.pojo.Cart;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface CartMapper extends Mapper<Cart> {


    @Select("select * from tb_cart where cid=#{cid}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(property="cid",column="cid"),
            @Result(property="count",column="count"),
            @Result(property="cartChecked",column="cart_checked"),
            @Result(property="images",column="images"),
            @Result(property="goodsName",column="goods_name"),
            @Result(property="price",column="price"),
            @Result(property="specListCode",column="spec_list_code"),

    })
    public Cart findById(@Param("cid") Integer cid);
}
