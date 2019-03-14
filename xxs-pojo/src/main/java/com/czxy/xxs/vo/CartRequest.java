package com.czxy.xxs.vo;

import lombok.Data;

@Data
public class CartRequest {

    private Integer cid ; //:"SKUID",
    private Integer count; //:"购买数量"
    private Boolean checked;
}
