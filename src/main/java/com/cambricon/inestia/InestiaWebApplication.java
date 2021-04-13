package com.cambricon.inestia;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {QuartzAutoConfiguration.class,DruidDataSourceAutoConfigure.class})
@EnableTransactionManagement
public class InestiaWebApplication extends SpringBootServletInitializer implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(InestiaWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(InestiaWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("官网服务启动完成!");
    }
}
