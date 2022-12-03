package com.mybatis.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.mybatis.demo.mapper.OrderMapper;
import com.mybatis.demo.model.Order;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

@ActiveProfiles("sharding")
@SpringBootTest
public class ShardingTest {
    @Autowired
    private OrderMapper orderMapper;
    @Test
    public void insertTest(){
        Order order = Order.builder().orderNo(100).num(100).version(1).source("a").createTime(new Date()).build();
        orderMapper.insert(order);
    }
    @Test
    public void selectTest(){
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no",100);
        List<Order> queryOrder = orderMapper.selectList(wrapper);
        System.out.println(queryOrder);
    }
    @Test
    public void rangeSelectTest(){
        QueryWrapper<Order>  rangeWrapper= new QueryWrapper<>();
        rangeWrapper.between("order_no",100,200);
        orderMapper.selectList(rangeWrapper);
    }
    @Test
    public void complexSelectTest(){
        QueryWrapper<Order>  complexWrapper= new QueryWrapper<>();
        complexWrapper.eq("order_no",100);
        complexWrapper.eq("num",100);
        orderMapper.selectList(complexWrapper);
    }
    @Test
    public void hintSelectTest(){
        HintManager hintManager = HintManager.getInstance();
        hintManager.addDatabaseShardingValue("t_order",1);
        hintManager.addTableShardingValue("t_order",2);
        orderMapper.selectList(null);
    }
}
