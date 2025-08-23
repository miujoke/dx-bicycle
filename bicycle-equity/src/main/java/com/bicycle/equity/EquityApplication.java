package com.bicycle.equity;

import com.bicycle.mq.producer.MqProducerService;
import jakarta.annotation.PostConstruct;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author miujoke
 * @date 2025/3/15 23:26
 */
@SpringBootApplication(scanBasePackages ="com.bicycle",exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {
        "com.bicycle.service",  // service 模块下所有 Bean（包含 MapperScan 配置类）
        "com.bicycle.equity",    // 当前模块
        "com.bicycle.common",    // c
        "com.bicycle.mq",    // mqservice
})
@MapperScan("com.bicycle.service.mapper")
public class EquityApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(EquityApplication.class, args);
        System.out.println("RocketMQTemplate Bean exists: " + ctx.containsBean("rocketMQTemplate"));
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EquityApplication.class);
    }
}
