package lzl.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.LockSupport;

public class Main {
    public static void main(String[] args)  {
        Random random = new Random();
        Map<Long, Integer> userServerIdMap = new HashMap<>();
        for (Long i = 0L; i < 10000000L; ++i){
            int serverId = random.nextInt();
            userServerIdMap.put(i, serverId);
        }
        System.out.println("done~");
        LockSupport.park();
    }
}