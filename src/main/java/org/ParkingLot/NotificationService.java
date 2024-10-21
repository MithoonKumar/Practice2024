package org.ParkingLot;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NotificationService {

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public void scheduleNotificationWithDelay(String vehicleNumber, Long waitTime, TimeUnit timeUnit) {
        this.scheduledExecutorService.schedule(()-> this.sendNotification(vehicleNumber), waitTime, timeUnit);
    }

    private void sendNotification(String vehicleNumber) {
        System.out.println("Sending notification to vehicle number:" + vehicleNumber);
    }
}
