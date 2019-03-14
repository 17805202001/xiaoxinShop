package com.czxy.xxs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "tb_foot")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Foot {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;


    //用户id
    @Column(name="uid")
    private Integer uid;

    //浏览的商品id
    @Column(name="gid")
    private Integer gid;

    //商品名字
    @Column(name="goods_name")
    private String goodsName;

    //商品图片
    @Column(name="images")
    private String images;

    //商品价格
    @Column(name="price")
    private Double price;

    //商品原价
    @Column(name="old_price")
    private Double oldPrice;



}