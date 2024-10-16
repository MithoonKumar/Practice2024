package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class UsageOfExecutorServiceWithCallable {

    public static void main(String[] args) {
        System.out.println("Hello");
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Callable<Integer>> callableList = new ArrayList<>();
        for (int i=0; i<10; i++) {
            int finalI = i;
            callableList.add(()-> {
                System.out.println("Started processing in thread :" + finalI);
                Thread.sleep(2000L);
                System.out.println("Completed processing in thread :" + finalI);
                return finalI;
            });
        }
        try {
            List<Future<Integer>> futureList = executorService.invokeAll(callableList);
            for (int i=0; i< futureList.size(); i++) {
                System.out.println("The result for callable : " + i + " is " + futureList.get(i).get());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}
