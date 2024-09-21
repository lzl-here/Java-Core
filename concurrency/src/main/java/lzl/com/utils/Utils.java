package lzl.com.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Timer;
import java.util.TimerTask;

public class Utils {
    public static void loopTimeTask(int loopNum, Runnable runnable) {
        Timer timer = new Timer("timer");
        for(int i = 0; i < loopNum; ++i){
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
//                    printCPU();
                    runnable.run();
                }
            };
            timer.schedule(timerTask, i * 1000L);
        }
    }

    public static void loopPrint(int loopNum){
        loopTimeTask(loopNum, Utils::printCPU);
    }

    private static void printCPU() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println("CPU使用率：" + osBean.getSystemLoadAverage());
    }

}
