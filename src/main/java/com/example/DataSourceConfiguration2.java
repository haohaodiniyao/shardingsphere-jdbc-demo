///*
//package com.example;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
//import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
//import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
//import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//@Configuration
//public class DataSourceConfiguration2 {
//    @Bean
//    public DataSource dataSource() throws Exception{
//        // 配置真实数据源
//        Map<String, DataSource> dataSourceMap = new HashMap<>();
//
//        // 配置第一个数据源
//        BasicDataSource dataSource1 = new BasicDataSource();
//        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource1.setUrl("");
//        dataSource1.setUsername("");
//        dataSource1.setPassword("");
//        dataSourceMap.put("ds_0", dataSource1);
//
//        // 配置第二个数据源
//        BasicDataSource dataSource2 = new BasicDataSource();
//        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource2.setUrl("");
//        dataSource2.setUsername("");
//        dataSource2.setPassword("");
//        dataSourceMap.put("ds_1", dataSource2);
//
//        // 配置Order表规则
//        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("t_order","ds_${0..1}.t_order_${0..1}");
//
//        // 配置分库 + 分表策略
//        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "ds_${user_id % 2}"));
//        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_${order_id % 2}"));
//
//        // 配置分片规则
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);
//
//        // 省略配置order_item表规则...
//        // ...
//
//        // 获取数据源对象
//        Properties properties = new Properties();
//        properties.setProperty("sql.show","true");
//        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, properties);
//        return dataSource;
//    }
//}
//*/
