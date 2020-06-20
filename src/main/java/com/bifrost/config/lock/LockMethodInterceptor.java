package com.bifrost.config.lock;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Aspect
@Configuration
public class LockMethodInterceptor {

    @Autowired
    public LockMethodInterceptor(RedissonClient redissonClient, CacheKeyGenerator cacheKeyGenerator) {
        this.redissonClient = redissonClient;
        this.cacheKeyGenerator = cacheKeyGenerator;
    }
    private final RedissonClient redissonClient;
    private final CacheKeyGenerator cacheKeyGenerator;

    @Pointcut("@annotation(com.bifrost.config.lock.LockSupport)")
    public void action(){

    }

    @Around("action()")
    public Object interceptor(ProceedingJoinPoint pjp)throws Throwable {
        final String lockKey = cacheKeyGenerator.getLockKey(pjp);
        log.info("lockKey:{}",lockKey);
        final RLock lock = redissonClient.getLock(lockKey);
        try {
            lock.lock();
            return pjp.proceed();
        } finally {
            lock.unlock();
        }
    }
}
