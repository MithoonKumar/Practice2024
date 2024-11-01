package practice.alarmLibrary;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.*;

public class AlarmScheduler {
    private HashMap<String, Alarm> alarmHashMap;
    private ScheduledExecutorService scheduledExecutorService;

    public AlarmScheduler(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
        this.alarmHashMap = new HashMap<>();
    }

    public String addAlarm(Schedule schedule, AlarmType alarmType, Runnable alarmTask) {
        String alaramId = UUID.randomUUID().toString();
        TimeUnit timeUnit = schedule.getTimeUnit();
        ScheduledFuture<?> scheduledFuture;
        if (alarmType == AlarmType.REPEATED) {
            scheduledFuture = this.scheduledExecutorService.scheduleAtFixedRate(alarmTask, schedule.getInitialDelay(), schedule.getRepeatDuration(), timeUnit);
        } else {
            scheduledFuture = this.scheduledExecutorService.schedule(alarmTask, schedule.getInitialDelay(), timeUnit);
        }
        Alarm alarm = new Alarm(schedule, alarmType, alarmTask, scheduledFuture);
        this.alarmHashMap.put(alaramId, alarm);
        return alaramId;
    }

    public synchronized void cancelAlarm(String alarmId) {
        if (this.alarmHashMap.containsKey(alarmId)) {
            boolean wasCancelled = this.alarmHashMap.get(alarmId).getScheduledFuture().cancel(true);
            if (wasCancelled) {
                System.out.println("The alarm has been successfully cancelled");
                this.alarmHashMap.remove(alarmId);
            } else {
                throw new AlarmCancellationException("Alarm could not be cancelled");
            }
        } else {
            throw new AlarmNotFoundException("This alarm does not exist");
        }
    }


}
