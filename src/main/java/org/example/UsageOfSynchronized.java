package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsageOfSynchronized {

    private static Integer counter;

    public static void main(String[] args) throws InterruptedException {
        counter = 0;
        System.out.println("Hello");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0; i<10000; i++) {
            executorService.submit(UsageOfSynchronized::testMethod);
        }
        executorService.shutdown();
        System.out.println(counter);
        Thread.sleep(8L);
        System.out.println(counter);

    }

    private static void testMethod() {
//        System.out.println("Incrementing the counter");
        synchronized (UsageOfSynchronized.class) {
            counter++;
        }
//        System.out.println("The counter is incremented");
    }
}
