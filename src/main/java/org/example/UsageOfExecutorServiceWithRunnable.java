package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsageOfExecutorServiceWithRunnable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        for (int i=0; i<10; i++) {
            int finalI = i;
            Runnable worker = () -> {
                System.out.println("Started processing in thread : + " + finalI);
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Completed processing in thread : + " + finalI);
            };
            executorService.submit(worker);
        }

        executorService.shutdown();
//        executorService.shutdownNow();

    }
}

//
//class WorkerThread implements Runnable {
//
//    private String threadName;
//
//    public WorkerThread(String threadName) {
//        this.threadName = threadName;
//    }
//
//    private void processCommand() {
//        try {
//            Thread.sleep(2000L);
////            System.out.println("Processed the request and I am printing from thread id: " + threadName);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Starting the processing of thread with id:" + threadName);
//        processCommand();
//        System.out.println("Completed the processing of thread with id:" + threadName);
//    }
//}