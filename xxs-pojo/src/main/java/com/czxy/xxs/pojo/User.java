package com.czxy.xxs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;



@Table(name = "tb_user")
@Data
//无参
@NoArgsConstructor

//有参
@AllArgsConstructor

@ToString

public class User implements Serializable {

    @Id

    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;

    //用户名
    @Column(name="name")
    private String name;

    //密码
    @Column(name="password")
    private String password;

    //邮箱
    @Column(name="email")
    private String email;

    //手机号
    @Column(name="mobile")
    private String mobile;





}
