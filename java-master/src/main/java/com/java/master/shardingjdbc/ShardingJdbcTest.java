package com.java.master.shardingjdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;

/**
 * @author wangqing 
 */

public class ShardingJdbcTest {

    public static void main(String[] args) {

    }

    private DataSource getDataSourceMap() throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<String, DataSource>();

        BasicDataSource dataSource1 = new BasicDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://localhost:3307/ds_0");
        dataSource1.setUsername("root");
        dataSource1.setPassword("123456");
        dataSourceMap.put("ds_0", dataSource1);

        BasicDataSource dataSource2 = new BasicDataSource();
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setUrl("jdbc:mysql://localhost:3307/ds_1");
        dataSource2.setUsername("root");
        dataSource2.setPassword("123456");
        dataSourceMap.put("ds_0", dataSource2);

        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
        orderTableRuleConfig.setLogicTable("t_order");
        orderTableRuleConfig.setActualDataNodes("ds_${0..1}.t_order_${[0, 1]}");

        InlineShardingStrategyConfiguration inlineShardingStrategyConfiguration = new InlineShardingStrategyConfiguration("user_id", "ds_${user_id % 2}");
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(inlineShardingStrategyConfiguration);

        InlineShardingStrategyConfiguration tabInlineShardingStrategyConfiguration = new InlineShardingStrategyConfiguration("order_id", "t_order_${order_id % 2}");
        orderTableRuleConfig.setTableShardingStrategyConfig(tabInlineShardingStrategyConfiguration);

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);

        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new HashMap<String, Object>(), new Properties());

        return dataSource;

    }

}
