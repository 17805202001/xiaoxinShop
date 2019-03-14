package com.czxy.xxs.dao;



import com.czxy.xxs.pojo.Order;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;


@org.apache.ibatis.annotations.Mapper
public interface OrderMapper extends Mapper<Order> {



    @Select("select * from tb_order where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="sn",property="sn"),
            @Result(column="shr_name",property="shrName"),
            @Result(column="count",property="count"),
            @Result(column="images",property="images"),
            @Result(column="mobile",property="mobile"),
            @Result(column="shr_province",property="shrProvince"),
            @Result(column="shr_address",property="shrAddress"),
            @Result(column="status",property="status"),
            @Result(column="goods_name",property="goodsName"),
            @Result(column="pay_time",property="payTime"),
            @Result(column="post_time",property="postTime"),
            @Result(column="total_price",property="totalPrice"),

    })
    public Order findById(@Param("id") Integer id);


}
