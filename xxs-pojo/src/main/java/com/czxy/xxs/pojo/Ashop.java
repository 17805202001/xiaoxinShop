package com.czxy.xxs.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_ashop")
public class Ashop {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sname")
    private String sname;
    @Column(name = "price")
    private Double price;
    @Column(name = "sprice")
    private Double sprice;

}

