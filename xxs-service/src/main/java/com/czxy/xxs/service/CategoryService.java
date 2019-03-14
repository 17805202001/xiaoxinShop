package com.czxy.xxs.service;


import com.czxy.xxs.Dao.CategoryMapper;
import com.czxy.xxs.pojo.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CategoryService {


    @Resource
    private CategoryMapper categoryMapper;

    public List<Category> findAll(){
        //查询所有
        Example example=new Example(Category.class);
//        example.setOrderByClause("parent_id asc");
        List<Category> temp=this.categoryMapper.selectByExample(example);


        //记录所有的父元素
        List<Category> list=new ArrayList<>();
        //记录所有的元素
        Map<Integer,Category> map=new HashMap<>();
        for(Category c:temp){
            if(c.getCat1_id()==0){
                list.add(c);
            }
            //存放元素
            map.put(c.getId(),c);
            Category parentCategory=map.get(c.getCat1_id());
            if(parentCategory!=null){
                parentCategory.getChildren().add(c);
            }
        }

        return list;
    }
}
