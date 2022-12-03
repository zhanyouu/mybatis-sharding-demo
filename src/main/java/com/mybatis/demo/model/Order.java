package com.mybatis.demo.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_order")//当数据库名与实体类名不一致或不符合驼峰命名时，需要在此注解指定表名（不加这个注解默认将实体类的小写形式在db中寻找）
public class Order {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("order_no")
    private Integer orderNo;
    @TableField("source")
    private String source;
    @TableField("num")
    private Integer num;
    @TableField(update = "%s+1",fill = FieldFill.UPDATE)
    private Integer version;
    @TableField(value = "create_time")//主要用来解决实体类的字段名与数据库中的字段名不匹配的问题（数据库create_time，字段createtime未驼峰）
    private Date createTime;
}
