package com.czxy.xxs.dao;


import com.czxy.xxs.pojo.Address;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface AddressMapper extends Mapper<Address> {


    @Select("select * from tb_address")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="shr_name",property="shrName"),
            @Result(column="mobile",property="mobile"),
            @Result(column="shr_province",property="shrProvince"),
            @Result(column="shr_address",property="shrAddress"),
            @Result(column="isdefault",property="isdefault"),

    })
        //根据商品id查询规格
    List<Address> findAddress();


    @Select("select * from tb_address where id=#{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="shr_name",property="shrName"),
            @Result(column="mobile",property="mobile"),
            @Result(column="shr_province",property="shrProvince"),
            @Result(column="shr_address",property="shrAddress"),
            @Result(column="isdefault",property="isdefault"),

    })
    public Address findById(@Param("id") Integer id);
}
