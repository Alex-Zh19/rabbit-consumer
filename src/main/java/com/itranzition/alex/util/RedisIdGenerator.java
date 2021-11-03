package com.itranzition.alex.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RedisIdGenerator {
    private long redisId;

    public long getRedisId() {
        return redisId++;
    }
}
