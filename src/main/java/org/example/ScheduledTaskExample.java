package org.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskExample {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        Runnable runnable = () -> {
            System.out.println("This task will be executed after 3 seconds");
        };
        executorService.schedule(runnable, 3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(runnable, 2, 2, TimeUnit.SECONDS);
//        executorService.shutdown();
    }
}
