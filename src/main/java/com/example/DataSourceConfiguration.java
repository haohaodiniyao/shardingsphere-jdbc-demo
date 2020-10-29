package com.example;

import com.google.common.collect.Lists;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

/**
 * 分片+主从
 */
@Configuration
public class DataSourceConfiguration {
    @Bean
    DataSource getDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        shardingRuleConfig.getTableRuleConfigs().add(getOrderItemTableRuleConfiguration());
        shardingRuleConfig.getBindingTableGroups().add("t_order,t_order_item");
//        shardingRuleConfig.getBroadcastTables().add("t_config");
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "ds_${user_id % 2}"));
        shardingRuleConfig.setMasterSlaveRuleConfigs(getMasterSlaveRuleConfigurations());
        Properties properties = new Properties();
        properties.setProperty("sql.show","true");
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig, properties);
    }

//    private static KeyGeneratorConfiguration getKeyGeneratorConfiguration() {
//        KeyGeneratorConfiguration result = new KeyGeneratorConfiguration("SNOWFLAKE", "order_id");
//        return result;
//    }

    TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("t_order", "ds_${0..1}.t_order_${[0, 1]}");
        result.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id","t_order_${order_id%2}"));
//        result.setKeyGeneratorConfig(getKeyGeneratorConfiguration());
        return result;
    }

    TableRuleConfiguration getOrderItemTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("t_order_item", "ds_${0..1}.t_order_item_${[0, 1]}");
        result.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id","t_order_item_${order_id%2}"));
        return result;
    }

    List<MasterSlaveRuleConfiguration> getMasterSlaveRuleConfigurations() {
        MasterSlaveRuleConfiguration masterSlaveRuleConfig1 = new MasterSlaveRuleConfiguration("ds_0", "demo_ds_master_0", Arrays.asList("demo_ds_master_0_slave_0", "demo_ds_master_0_slave_1"));
        MasterSlaveRuleConfiguration masterSlaveRuleConfig2 = new MasterSlaveRuleConfiguration("ds_1", "demo_ds_master_1", Arrays.asList("demo_ds_master_1_slave_0", "demo_ds_master_1_slave_1"));
        return Lists.newArrayList(masterSlaveRuleConfig1, masterSlaveRuleConfig2);
    }

    Map<String, DataSource> createDataSourceMap() {
        BasicDataSource dataSource1 = new BasicDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("");
        dataSource1.setUsername("");
        dataSource1.setPassword("");

        BasicDataSource dataSource2 = new BasicDataSource();
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setUrl("");
        dataSource2.setUsername("");
        dataSource2.setPassword("");

        BasicDataSource dataSource3 = new BasicDataSource();
        dataSource3.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource3.setUrl("");
        dataSource3.setUsername("");
        dataSource3.setPassword("");

        BasicDataSource dataSource4 = new BasicDataSource();
        dataSource4.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource4.setUrl("");
        dataSource4.setUsername("");
        dataSource4.setPassword("");

        BasicDataSource dataSource5 = new BasicDataSource();
        dataSource5.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource5.setUrl("");
        dataSource5.setUsername("");
        dataSource5.setPassword("");

        BasicDataSource dataSource6 = new BasicDataSource();
        dataSource6.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource6.setUrl("");
        dataSource6.setUsername("");
        dataSource6.setPassword("");


        final Map<String, DataSource> result = new HashMap<>();
        result.put("demo_ds_master_0", dataSource1);
        result.put("demo_ds_master_0_slave_0", dataSource2);
        result.put("demo_ds_master_0_slave_1", dataSource3);
        result.put("demo_ds_master_1", dataSource4);
        result.put("demo_ds_master_1_slave_0", dataSource5);
        result.put("demo_ds_master_1_slave_1", dataSource6);
        return result;
    }
}
