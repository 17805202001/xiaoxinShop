package com.czxy.xxs.service;


import com.czxy.xxs.dao.AddressMapper;
import com.czxy.xxs.pojo.Address;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AddressService {

    @Resource
    private AddressMapper addressMapper;

    //添加地址
    public void addAddress(Address address){
        address.setIsdefault(false);
        this.addressMapper.insert(address);

    }


    //查询购物车
    public List<Address> findAddress() {

        List<Address> list= this.addressMapper.findAddress();

        return list;
    }


    //修改地址
    public void updateAddress(Address address){

        List<Address> list= this.addressMapper.findAddress();


        for(Address a:list){
            if(a.getId()!=address.getId()){
                a.setIsdefault(false);
            }else{
                a.setIsdefault(true);
            }
            this.addressMapper.updateByPrimaryKey(a);
        }
    }


    //在订单页面展示默认地址
    public  Address findAdd() {
        //查询所有地址信息
        List<Address> list= this.addressMapper.findAddress();

        Address add=new Address();
        //遍历集合
        for(Address a:list){
            //判断默认的地址
            if(a.getIsdefault()==true){
                add.setShrName(a.getShrName());
                add.setShrAddress(a.getShrAddress());
                add.setShrProvince(a.getShrProvince());
                add.setMobile(a.getMobile());
            }

        }
        return add;
    }

    //删除地址
    public void deleteAddress(Integer id) {
        System.out.println(id);
        Address a=addressMapper.findById(id);
        this.addressMapper.delete(a);

    }

}
