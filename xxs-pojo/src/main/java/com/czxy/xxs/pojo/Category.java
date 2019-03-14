package com.czxy.xxs.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by liangtong.
 */
@Table(name="tb_category")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Category {

    @Id
    private Integer id;
    @Column(name="cat_name")
    @JsonProperty("cat_name")
    private String catName;
    @Column(name="cat1_id")
    @JsonProperty("cat1_id")
    private Integer cat1_id;
    @Column(name="cat2_id")
    @JsonProperty("cat2_id")
    private Boolean cat2_id;

    private List<Category> children = new ArrayList<>();

}
