package com.mybatis.demo.sharding.algorithm;

import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;

public class MyTableRangeShardingAlgorithm implements RangeShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Integer> rangeShardingValue) {
        String columnName = rangeShardingValue.getColumnName();
        String logicTableName = rangeShardingValue.getLogicTableName();
        Range<Integer> valueRange = rangeShardingValue.getValueRange();
        return Lists.newArrayList("t_order_1","t_order_2");
    }
}
