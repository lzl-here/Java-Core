package lzl.com.lock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedisLock {

    public static final RLock rLock;
    public static final Config config = new Config();
    public static RedissonClient redissonClient;

    static {
        config.useSingleServer().setAddress("redis://localhost:6379");
        redissonClient = Redisson.create(config);
        rLock = redissonClient.getLock("lock:1");
    }
}
