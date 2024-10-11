package caffine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;

public class Main {

    private static final Cache<Long, Set<Long>> caffeine = Caffeine.newBuilder()
            .build();

    public static void main(String[] args) {
        Random random = new Random();
        for(long i = 0; i < 300000L; ++i){
            int serverId = random.nextInt();
            Set<Long> groupUserIdSet = new HashSet<>(200 + 1);
            for (int j = 0; j < 200; j++) {
                groupUserIdSet.add(Long.valueOf(j));
            }
            caffeine.put(i, groupUserIdSet);
        }
        System.out.println("done~");
        LockSupport.park();
    }
}
