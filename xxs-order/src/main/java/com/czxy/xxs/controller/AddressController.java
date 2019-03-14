package com.czxy.xxs.controller;

import com.czxy.xxs.pojo.Address;
import com.czxy.xxs.service.AddressService;
import com.czxy.xxs.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;



@RestController
@RequestMapping
public class AddressController {

    @Resource
    private AddressService addressService;



    //添加地址
    @PostMapping("/address")
    public ResponseEntity<BaseResult> addAddress(@RequestBody Address address) {

        addressService.addAddress(address);

        return ResponseEntity.ok( new BaseResult(0 , "成功1") );

    }

    //查询地址
    @GetMapping("/address")
    public ResponseEntity<BaseResult> findAddress(){
        //查询所有
        List<Address> list=this.addressService.findAddress();
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",list));
    }

    //修改地址
    @PutMapping("/address")
    public ResponseEntity<BaseResult> updateAddress(@RequestBody Address address) {
        System.out.println(address);
        addressService.updateAddress(address);

        return ResponseEntity.ok( new BaseResult(0 , "成功1") );

    }


    //在订单页面展示默认地址
    @GetMapping("/add")
    public ResponseEntity<BaseResult> findAdd(){
        //查询所有
        Address add=this.addressService.findAdd();
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",add));
    }


    //删除地址
    @DeleteMapping("/address/{id}")
    public ResponseEntity<BaseResult> deleteAddress(@PathVariable("id") Integer id) {

        addressService.deleteAddress(id);

        return ResponseEntity.ok( new BaseResult(0 , "成功1") );

    }
}
