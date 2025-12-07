package com.peng.sms.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis configration
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}
