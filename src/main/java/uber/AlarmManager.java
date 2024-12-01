package uber;


import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AlarmManager {

    ExecutorService service;
    HashMap<String, Alarm> alarmMap;
    Long gracePeriod;

    public AlarmManager(int numOfThreadPools, Long gracePeriod) {
        this.service = Executors.newFixedThreadPool(numOfThreadPools);
        this.alarmMap = new HashMap<>();
        this.gracePeriod = gracePeriod;
    }

    public String addAlarm(Long duration) {
        String alarmId = UUID.randomUUID().toString();
        Alarm alarm = new Alarm(alarmId,  AlarmType.RECURRING, duration);
        Runnable runnable = () -> {
            while (true) {
                if (alarm.alarmState!= AlarmState.CANCELLED && alarm.executionTime <= System.currentTimeMillis()) {
                    System.out.println("Running alarm for alarm id: " + alarmId);
                    alarm.executionTime = alarm.executionTime + alarm.duration;
                }
                try {
                    Thread.sleep(alarm.executionTime - System.currentTimeMillis() + gracePeriod);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Future<?> future = this.service.submit(runnable);
        alarm.setAlarmFuture(future);
        this.alarmMap.put(alarmId, alarm);
        return alarmId;
    }

    public void cancelAlarm(String alarmId) {
        Alarm alarm = this.alarmMap.get(alarmId);
        if (alarm != null) {
            alarm.cancelAlarm();
            boolean isCancelled = alarm.alarmFuture.cancel(true);
            if (isCancelled) {
                System.out.println("Alarm was cancelled");
            } else {
                System.out.println("Alarm was not cancelled");
            }
        } else {
            throw new RuntimeException("No alarm found");
        }
    }
}
