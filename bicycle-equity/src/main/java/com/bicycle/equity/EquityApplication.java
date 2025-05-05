package com.bicycle.equity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author miujoke
 * @date 2025/3/15 23:26
 */
@SpringBootApplication(scanBasePackages ="com.bicycle",exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {
        "com.bicycle.service",  // service 模块下所有 Bean（包含 MapperScan 配置类）
        "com.bicycle.equity",    // 当前模块
        "com.bicycle.common"    // c
})
@MapperScan("com.bicycle.service.mapper")
public class EquityApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EquityApplication.class);
        //app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EquityApplication.class);
    }
}
