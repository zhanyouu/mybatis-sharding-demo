package com.mybatis.demo.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class MyTablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Integer> preciseShardingValue) {
        String logicTableName = preciseShardingValue.getLogicTableName();
        String columnName = preciseShardingValue.getColumnName();
        Integer value = preciseShardingValue.getValue();
        if(value == 100){
            return "t_order_1";
        }
        return "t_order_2";
    }
}
