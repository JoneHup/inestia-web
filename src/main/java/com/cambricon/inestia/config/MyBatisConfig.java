package com.cambricon.inestia.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = "com.cambricon.inestia.modules.*.mapper")
public class MyBatisConfig {

}
