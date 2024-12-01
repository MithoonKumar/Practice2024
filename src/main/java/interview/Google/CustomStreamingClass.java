package interview.Google;

import java.util.concurrent.PriorityBlockingQueue;

public class CustomStreamingClass {

    private PriorityBlockingQueue<Long> priorityBlockingQueue;
    private Thread thread;


    public CustomStreamingClass() {
        this.priorityBlockingQueue = new PriorityBlockingQueue<>();
    }


    public void addData(Long data) {
        this.priorityBlockingQueue.add(data);
    }

    private Long removeAndGetTopData() {
        return this.priorityBlockingQueue.poll();
    }


    public void startStreaming(long numOfPacketsPerSecond) {
        long intervalBetweenPacketsInMillis = 1000/numOfPacketsPerSecond;
        Runnable runnable = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                Long data = this.priorityBlockingQueue.poll();
                if (data != null) {
                    System.out.println("Streaming data with value: " + data);
                }
                try {
                    Thread.sleep(intervalBetweenPacketsInMillis);
                } catch (InterruptedException e) {
                    System.out.println("Streaming interrupted");
                    break;
                }
            }
        };
        this.thread = new Thread(runnable);
        thread.start();
    }

    public void stopStreaming() {
        if (thread != null && thread.isAlive()) {
            this.thread.interrupt();
            System.out.println("Streaming stopped");
        } else {
            System.out.println("Streaming is already stopped");
        }

    }

}
