package com.czxy.xxs.service;


import com.czxy.xxs.Dao.SeckillMapper;
import com.czxy.xxs.pojo.Seckill;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

@Service
@Transactional
public class SeckillService {

    @Resource
    private SeckillMapper seckillMapper;


    //商品秒杀
    public List<Seckill> seckillShop(){
        List<Seckill> list=seckillMapper.selectAll();
        return list;
    }


    //秒杀商品状态修改
    public void updateShop(Seckill seckill) throws Exception {

        List<Seckill> list=seckillMapper.selectAll();

//        //获取抢购当前时间
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        //转换成date格式
//       Date nowTime=df.parse(df.format(new Date()));
//        //获取毫秒值
//        Long n=nowTime.getTime();

        for(Seckill s:list){
            if (s.getId()==seckill.getId()) {

                Integer stock=seckill.getStock()-1;
                s.setStock(stock);

                if(s.getStock()==0){
                    s.setCheckStatus(!seckill.getCheckStatus());
                }

//                //获取抢购结束时间
//                String endTime=seckill.getEndTime();
//                //转换成date格式
//                Date date =new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
//                //获取毫秒值
//                Long e=date.getTime();
//
//                //设置结束状态
//                if(e<n){
//                    s.setCheckStatus(true);
//                }else {
//                    s.setCheckStatus(false);
//                }


            }
            this.seckillMapper.updateByPrimaryKey(s);
        }

    }
}
