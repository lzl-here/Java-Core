package com.lzl;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class Main {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://10.78.79.223:6379");
        RedissonClient redissonClient = Redisson.create(config);
        redissonClient.getKeys().getKeys().forEach(System.out::println);
    }
}
