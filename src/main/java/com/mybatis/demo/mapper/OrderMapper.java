package com.mybatis.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.demo.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
