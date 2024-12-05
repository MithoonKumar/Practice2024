package Atlassian;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TokenBucketAlgorithm {
    private final long maxTokens;
    private final double tokenRefillRatePerMillis;
    private double currentTokens;
    private long lastRefillTimeStamp;


    public TokenBucketAlgorithm(long maxTokens, double tokenRefillRatePerMillis) {
        this.maxTokens = maxTokens;
        this.tokenRefillRatePerMillis = tokenRefillRatePerMillis;
        this.currentTokens = 0;
        this.lastRefillTimeStamp = System.currentTimeMillis();
    }

    public synchronized boolean isAllowed() {
        refill();
        if (currentTokens  >= 1) {
            currentTokens--;
            return true;
        }
        return false;
    }

    public void refill() {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - this.lastRefillTimeStamp;

        double tokensToBeFilled = (double) timeElapsed * tokenRefillRatePerMillis;
        this.currentTokens = Math.min(this.maxTokens, this.currentTokens + tokensToBeFilled);
        this.lastRefillTimeStamp = currentTime;
    }

    public static void main(String[] args) {
        TokenBucketAlgorithm tokenBucketAlgorithm = new TokenBucketAlgorithm(10, 0.001);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println(tokenBucketAlgorithm.isAllowed());
        }, 0, 100, TimeUnit.MILLISECONDS);
    }


}
