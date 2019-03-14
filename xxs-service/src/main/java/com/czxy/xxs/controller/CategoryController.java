package com.czxy.xxs.controller;

import com.czxy.xxs.pojo.Category;
import com.czxy.xxs.service.CategoryService;
import com.czxy.xxs.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;



@RestController
@RequestMapping
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    //查询商品信息
    @GetMapping("/categorys")
    public ResponseEntity<BaseResult> findAll(){
        //查询所有
        List<Category> list=this.categoryService.findAll();
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",list));
    }
}
