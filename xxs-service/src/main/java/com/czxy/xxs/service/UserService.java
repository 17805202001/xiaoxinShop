package com.czxy.xxs.service;


import com.czxy.xxs.Dao.UserMapper;
import com.czxy.xxs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;


    //注册
    public void regist(User user){
        userMapper.insert(user);
    }


    /**
     * 通过手机号查询
     * @param mobile
     * @return
     */
    public User findByMobile(String mobile){
        System.out.println(mobile);
        //1 拼凑条件
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("mobile" , mobile );
        //2 查询
        return this.userMapper.selectOneByExample( example );
    }
}
