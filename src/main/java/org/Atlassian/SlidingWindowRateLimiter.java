package org.Atlassian;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SlidingWindowRateLimiter {
    private final long windowLengthInMillis;
    private final Queue<Long> queue;
    private final long maxRequestsAllowed;


    public SlidingWindowRateLimiter(long windowLengthInMillis, long maxRequestsAllowed) {
        this.windowLengthInMillis = windowLengthInMillis;
        this.maxRequestsAllowed = maxRequestsAllowed;
        this.queue = new LinkedList<>();
    }

    public synchronized boolean isAllowed() {
        long currentTime = System.currentTimeMillis();
        while (!queue.isEmpty() && currentTime - queue.peek() > this.windowLengthInMillis) {
            queue.poll();
        }
        if (this.queue.size() < this.maxRequestsAllowed) {
            queue.add(currentTime);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SlidingWindowRateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(1000L, 1L);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println(slidingWindowRateLimiter.isAllowed());
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
}
