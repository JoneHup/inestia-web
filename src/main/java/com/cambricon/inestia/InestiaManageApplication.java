package com.cambricon.inestia;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {QuartzAutoConfiguration.class,DruidDataSourceAutoConfigure.class})
@EnableTransactionManagement
//@MapperScan(basePackages = "com.cambricon.inestia.modules.*.mapper")
public class InestiaManageApplication extends SpringBootServletInitializer implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(InestiaManageApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(InestiaManageApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("后台管理系统启动完成!");
    }
}
