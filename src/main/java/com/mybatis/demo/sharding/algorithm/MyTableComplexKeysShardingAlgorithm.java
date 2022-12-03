package com.mybatis.demo.sharding.algorithm;

import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.Collection;
import java.util.Map;

public class MyTableComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, ComplexKeysShardingValue<Integer> complexKeysShardingValue) {
        String logicTableName = complexKeysShardingValue.getLogicTableName();
        Map<String, Range<Integer>> columnNameAndRangeValuesMap = complexKeysShardingValue.getColumnNameAndRangeValuesMap();
        Map<String, Collection<Integer>> columnNameAndShardingValuesMap = complexKeysShardingValue.getColumnNameAndShardingValuesMap();
        return Lists.newArrayList("t_order_1","t_order_2");
    }
}
