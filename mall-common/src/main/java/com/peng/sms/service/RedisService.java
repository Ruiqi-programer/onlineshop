package com.peng.sms.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis operation service
 */
public interface RedisService {

    /**
     * Save a value with an expiration time
     */
    void set(String key, Object value, long time);

    /**
     * Save a value without expiration
     */
    void set(String key, Object value);

    /**
     * Get a value by key
     */
    Object get(String key);

    /**
     * Delete a value by key
     */
    Boolean del(String key);

    /**
     * Delete multiple keys
     */
    Long del(List<String> keys);

    /**
     * Set expiration time for a key
     */
    Boolean expire(String key, long time);

    /**
     * Get remaining expiration time for a key
     */
    Long getExpire(String key);

    /**
     * Check if a key exists
     */
    Boolean hasKey(String key);

    /**
     * Increment a key by delta
     */
    Long incr(String key, long delta);

    /**
     * Decrement a key by delta
     */
    Long decr(String key, long delta);

    /**
     * Get a value from a Hash
     */
    Object hGet(String key, String hashKey);

    /**
     * Put a value into a Hash with expiration
     */
    Boolean hSet(String key, String hashKey, Object value, long time);

    /**
     * Put a value into a Hash without expiration
     */
    void hSet(String key, String hashKey, Object value);

    /**
     * Get the entire Hash
     */
    Map<Object, Object> hGetAll(String key);

    /**
     * Set an entire Hash with expiration
     */
    Boolean hSetAll(String key, Map<String, Object> map, long time);

    /**
     * Set an entire Hash without expiration
     */
    void hSetAll(String key, Map<String, ?> map);

    /**
     * Delete one or more Hash entries
     */
    void hDel(String key, Object... hashKey);

    /**
     * Check if a Hash contains a key
     */
    Boolean hHasKey(String key, String hashKey);

    /**
     * Increment a Hash value by delta
     */
    Long hIncr(String key, String hashKey, Long delta);

    /**
     * Decrement a Hash value by delta
     */
    Long hDecr(String key, String hashKey, Long delta);

    /**
     * Get all members of a Set
     */
    Set<Object> sMembers(String key);

    /**
     * Add one or more members to a Set
     */
    Long sAdd(String key, Object... values);

    /**
     * Add one or more members to a Set with expiration
     */
    Long sAdd(String key, long time, Object... values);

    /**
     * Check if a value is a member of a Set
     */
    Boolean sIsMember(String key, Object value);

    /**
     * Get the size of a Set
     */
    Long sSize(String key);

    /**
     * Remove one or more members from a Set
     */
    Long sRemove(String key, Object... values);

    /**
     * Get a range of elements from a List
     */
    List<Object> lRange(String key, long start, long end);

    /**
     * Get the size of a List
     */
    Long lSize(String key);

    /**
     * Get an element from a List by index
     */
    Object lIndex(String key, long index);

    /**
     * Push a value to the end of a List
     */
    Long lPush(String key, Object value);

    /**
     * Push a value to the end of a List with expiration
     */
    Long lPush(String key, Object value, long time);

    /**
     * Push multiple values to a List
     */
    Long lPushAll(String key, Object... values);

    /**
     * Push multiple values to a List with expiration
     */
    Long lPushAll(String key, Long time, Object... values);

    /**
     * Remove elements from a List
     */
    Long lRemove(String key, long count, Object value);
}
