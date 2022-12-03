package com.mybatis.demo.sharding.algorithm;

import com.google.common.collect.Lists;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Collection;

public class MyDBHintShardingAlgorithm implements HintShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<Integer> hintShardingValue) {
        String columnName = hintShardingValue.getColumnName();
        Collection<Integer> values = hintShardingValue.getValues();
        if(values.contains(1)){
            return Lists.newArrayList("ds1");
        }
        return Lists.newArrayList("ds2");
    }
}
