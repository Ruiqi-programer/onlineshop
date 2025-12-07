package com.peng.sms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis related configuration
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.peng.sms.mapper", "com.peng.sms.dao"})
public class MyBatisConfig {
}
