package com.peng.sms.service.impl;

import com.peng.sms.annotation.CacheException;
import com.peng.sms.model.UmsMember;
import com.peng.sms.service.RedisService;
import com.peng.sms.service.UmsMemberCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Implementation of UmsMemberCacheService
 * Handles caching of member information and authentication codes in Redis
 */
@Service
public class UmsMemberCacheServiceImpl implements UmsMemberCacheService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.database}")
    private String REDIS_DATABASE; // Redis database prefix
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE; // Expiration time for common cache
    @Value("${redis.expire.authCode}")
    private Long REDIS_EXPIRE_AUTH_CODE; // Expiration time for auth codes
    @Value("${redis.key.member}")
    private String REDIS_KEY_MEMBER; // Redis key prefix for member info
    @Value("${redis.key.authCode}")
    private String REDIS_KEY_AUTH_CODE; // Redis key prefix for auth codes

    /**
     * Delete member information from Redis
     */
    @Override
    public void delMember(Long memberId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + memberId;
        redisService.del(key);
    }

    /**
     * Get member information from Redis
     */
    @Override
    public UmsMember getMember(Long memberId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + memberId;
        return (UmsMember) redisService.get(key);
    }

    /**
     * Set member information into Redis with expiration
     */
    @Override
    public void setMember(UmsMember member) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + member.getId();
        redisService.set(key, member, REDIS_EXPIRE);
    }

    /**
     * Set auth code for a telephone number in Redis
     * Annotated with @CacheException to handle Redis exceptions gracefully
     */
    @CacheException
    @Override
    public void setAuthCode(String telephone, String authCode) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + telephone;
        redisService.set(key, authCode, REDIS_EXPIRE_AUTH_CODE);
    }

    /**
     * Get auth code for a telephone number from Redis
     */
    @CacheException
    @Override
    public String getAuthCode(String telephone) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + telephone;
        return (String) redisService.get(key);
    }
}
