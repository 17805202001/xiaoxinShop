package com.czxy.xxs.vo;


import lombok.Data;

@Data
public class PageRequest {

    private Integer limit;// 限制条数
    private Integer offset;// 起始索引
    private Integer page; // 当前页
    private Integer perPage;// 每页条数
    private String sortBy; // 排序字段
    private String sortWay; //排序方式  asc  升序   desc  降序

}
