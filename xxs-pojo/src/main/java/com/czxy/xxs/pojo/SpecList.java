package com.czxy.xxs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "tb_spec_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SpecList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "spec_name")
    private String specName;

    @Column(name = "category_id")
    private Integer categoryId;
    @Transient
    private Category category;
    @Transient
    private List<SpecListOption> options;
}