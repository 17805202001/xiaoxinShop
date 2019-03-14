package com.czxy.xxs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "tb_spec_list_option")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SpecListOption implements Serializable {
    @Id
    //自动增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "spec_id")
    private Integer specId;
    @Transient
    private SpecList specList;

    @Column(name = "option_name")
    private String optionName;

    @Column(name = "spec_checked")
    private String specChecked;
}
