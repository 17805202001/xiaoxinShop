package com.czxy.xxs.Dao;

import com.czxy.xxs.pojo.SpecList;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SpecMapper extends Mapper<SpecList> {


    @Select("select * from tb_spec_list")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="spec_name",property="specName"),
            @Result(column="category_id",property="categoryId"),
            @Result(column="id",property="options",
                    many=@Many(
                            select="com.czxy.xxs.Dao.SpecListMapper.findSpecListOption"
                    )
            )
    })
        //根据商品id查询规格
    List<SpecList> findSpecListByCategoryId();

}
