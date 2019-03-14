package com.czxy.xxs.Dao;

import com.czxy.xxs.pojo.SpecListOption;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SpecListMapper extends Mapper<SpecListOption> {


    @Select("select * from tb_spec_list_option where spec_id = #{specId}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="spec_id",property="specId"),
            @Result(column="option_name",property="optionName"),
            @Result(column="spec_checked",property="specChecked"),
    })
        //根据规格id查询规格内容
    List<SpecListOption> findSpecListOption(@Param("specId") Integer specId);

}
