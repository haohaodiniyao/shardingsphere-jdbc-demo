package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@MapperScan("com.example.mapper")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages = "com.example")
public class ShardingsphereJdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingsphereJdbcDemoApplication.class, args);
    }

}
