package com.czxy.xxs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by liangtong.
 */
@Table(name = "tb_order")
@Data
@NoArgsConstructor

@AllArgsConstructor
@ToString
public class Order implements Serializable {

    @Column(name="id")
    private Integer id;

    //订单序列号
    @Column(name="sn")
    private String sn;

    //收货人姓名
    @Column(name="shr_name")
    private String shrName;

    //收货人手机
    @Column(name="count")
    private Integer count;

    //收货人手机
    @Column(name="images")
    private String images;


    //收货人手机
    @Column(name="mobile")
    private String mobile;
    //收货人省份
    @Column(name="shr_province")
    private String shrProvince;

    //收货人详情地址
    @Column(name="shr_address")
    private String shrAddress;

    //订单状态，0:未支付、1:已支付、等待发货、2:已发货、等待收货 3:已收货、等待评论 4:已结束 5:申请售后
    @Column(name="status")
    private Integer status;

    //商品名称
    @Column(name="goods_name")
    private String goodsName;


    //支付时间
    @Column(name="pay_time")
    private String payTime;

    //发货时间
    @Column(name="post_time")
    private String postTime;


    //订单总价
    @Column(name="total_price")
    private Double totalPrice;
}

