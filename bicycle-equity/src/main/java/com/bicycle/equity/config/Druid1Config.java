package com.bicycle.equity.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author miujoke
 * @date 2025/3/17 0:02
 */
@Configuration
public class Druid1Config {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid1")
    public DataSource druid1DataSource() {
        DruidDataSource druid1DataSource = new DruidDataSource();
        return druid1DataSource;
    }
}
