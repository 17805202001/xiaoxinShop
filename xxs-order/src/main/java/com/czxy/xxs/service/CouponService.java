package com.czxy.xxs.service;


import com.czxy.xxs.dao.CouponMapper;
import com.czxy.xxs.pojo.Coupon;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional

public class CouponService {

    @Resource
    private CouponMapper couponMapper;


    public List<Coupon> findAll(){
        List<Coupon> list=this.couponMapper.selectAll();

        return list;
    }
}
