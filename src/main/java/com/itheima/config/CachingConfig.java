package com.itheima.config;


import com.itheima.constant.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager(){
        SimpleCacheManager scm=new SimpleCacheManager();
        scm.setCaches(Arrays.asList(new ConcurrentMapCache(Cache.STUDENT)
        ,new ConcurrentMapCache(Cache.SCHOOL)
        ,new ConcurrentMapCache(Cache.STU_SCH)
        ,new ConcurrentMapCache(Cache.ADMIN)
        ));
        return  scm;
    }

}
