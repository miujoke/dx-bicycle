package com.bicycle.equity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author miujoke
 * @date 2025/3/15 23:26
 */
@SpringBootApplication
@ComponentScan({"com.bicycle.common.service.impl", "com.bicycle"})
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
