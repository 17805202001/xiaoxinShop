package com.czxy.xxs.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="tb_seckill")
public class Seckill {


    @Id
    private Integer id;

    @Column(name="sname")
    private String sname;

    @Column(name="start_time")
    private String startTime;

    @Column(name="end_time")
    private String endTime;

    @Column(name="stock")
    private Integer stock;

    @Column(name="price")
    private Double price;


    @Column(name="check_status")
    private Boolean checkStatus;
}
