package com.czxy.xxs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "tb_goods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Goods {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    //商品描述
    @Column(name="describe")
    private String describe;

    @Column(name="cid")
    private Integer cid;

    //sku名字
    @Column(name="goods_name")
    private String goodsName;

    @Column(name="images")
    private String images;


    @Column(name="price")
    private Double price;

    @Column(name="prices")
    private Double prices;

    //1:1|2:6|6:22
    @Column(name="spec_list")
    private String specList;
    //规格列表码,格式：{"机身颜色":"白色","内存":"3GB","机身存储":"16GB"}
    @Column(name="spec_list_code")
    private String specListCode;

}