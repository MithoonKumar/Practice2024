package org.SlidingWindowRateLimiter;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class RateLimiter {
    private Integer maxRequests;
    private Long windowSizeInMillis;
    private Queue<Long> queue;

    public RateLimiter(Integer maxRequests, Long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.queue = new LinkedList<>();
    }

    public synchronized Boolean isAllowed () {
        long currentTime = Instant.now().toEpochMilli();
        while (!queue.isEmpty() && currentTime - windowSizeInMillis > queue.peek()) {
            queue.poll();
        }
        if (queue.size() < maxRequests) {
            queue.add(currentTime);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        // Example: Allow max 3 requests in a 5-second window
        RateLimiter rateLimiter = new RateLimiter(3, 5000L);  // 5 seconds window (5000 ms)

        // Simulate 6 requests with 1 second interval
        for (int i = 1; i <= 6; i++) {
            boolean allowed = rateLimiter.isAllowed();
            System.out.println("Request " + i + " is allowed: " + allowed);

            // Sleep for 1 second between requests to simulate real-world behavior
            Thread.sleep(1000);
        }

        // Simulate 2 more requests after 6 seconds (the window will reset)
        Thread.sleep(6000);
        System.out.println("Request 7 after window reset is allowed: " + rateLimiter.isAllowed());
        System.out.println("Request 8 after window reset is allowed: " + rateLimiter.isAllowed());
    }
}
