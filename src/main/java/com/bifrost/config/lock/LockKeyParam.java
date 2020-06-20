package com.bifrost.config.lock;

import java.lang.annotation.*;

/**
 * 锁的参数
 * @author chendesheng
 * @create 2019/10/11 16:08
 */
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LockKeyParam {

    /**
     * 字段名称
     *
     * @return String
     */
    String name() default "uid";
}