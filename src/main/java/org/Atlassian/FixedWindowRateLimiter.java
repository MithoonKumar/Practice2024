package org.Atlassian;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedWindowRateLimiter {
    private final long windowLengthInMillis;
    private long windowStartTime;
    private long windowEndTime;
    private final long maxRequestsAllowed;
    private long currentWindowRequestCount;


    public FixedWindowRateLimiter(long windowLengthInMillis, long maxRequestsAllowed) {
        if (windowLengthInMillis <= 0) {
            throw new IllegalArgumentException("Window length must be positive");
        }
        if (maxRequestsAllowed <=0 ){
            throw new IllegalArgumentException("Number of requests allowed must be positive");
        }
        this.windowLengthInMillis = windowLengthInMillis;
        this.maxRequestsAllowed = maxRequestsAllowed;
        this.windowStartTime = System.currentTimeMillis();
        this.windowEndTime = this.windowStartTime + this.windowLengthInMillis;
        this.currentWindowRequestCount = 0;
    }


    public synchronized boolean isAllowed() {
        long currentTimeStamp = System.currentTimeMillis();
        if (currentTimeStamp >= this.windowEndTime) {
            this.windowStartTime = currentTimeStamp;
            this.windowEndTime = this.windowStartTime + this.windowLengthInMillis;
            this.currentWindowRequestCount = 1;
            return true;
        } else if (this.currentWindowRequestCount < this.maxRequestsAllowed) {
            this.currentWindowRequestCount++;
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        FixedWindowRateLimiter fixedWindowRateLimiter = new FixedWindowRateLimiter(1000L, 1L);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println(fixedWindowRateLimiter.isAllowed());
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
}
