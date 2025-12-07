package com.peng.sms.annotation;

import java.lang.annotation.*;

/**
 * Custom annotation. Methods with this annotation
 * will throw an exception when caching occurs.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
