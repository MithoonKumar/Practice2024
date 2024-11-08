package interview.uber.alarmLibrary;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class AlarmManager {
    private HashMap<String, Alarm> alarmHashMap;
    private ScheduledExecutorService scheduledExecutorService;

    public AlarmManager(int numOfThreadPool) {
        this.alarmHashMap = new HashMap<>();
        this.scheduledExecutorService = Executors.newScheduledThreadPool(numOfThreadPool);
    }

    public String addAlarm(Schedule schedule, AlarmType alarmType) {
        String alarmId = UUID.randomUUID().toString();
        Alarm alarm = new Alarm(alarmId, schedule, alarmType, AlarmState.SCHEDULED, () -> {
            System.out.println("The alarm with alarmId:" + alarmId + " is running");
        });
        alarm.setAlarmState(AlarmState.SCHEDULED);
        this.alarmHashMap.put(alarmId, alarm);
        ScheduledFuture<?> scheduledFuture;
        if (alarmType.equals(AlarmType.ONETIME)) {
            scheduledFuture = this.scheduledExecutorService.schedule(alarm::execute, schedule.getInitialDelay(), TimeUnit.SECONDS);
        } else {
            scheduledFuture = this.scheduledExecutorService.scheduleAtFixedRate(alarm::execute, schedule.getInitialDelay(), schedule.getRepeatDuration(), TimeUnit.SECONDS);
        }
        alarm.setScheduledFuture(scheduledFuture);
        return alarmId;
    }

    public AlarmState getStateOfAlarm(String alarmId) {
        if (!this.alarmHashMap.containsKey(alarmId)) {
            throw new AlarmNotFoundException("No alarm with alarmId : " + alarmId + " exists");
        }
        return this.alarmHashMap.get(alarmId).getAlarmState();
    }

    public void cancelAlarm(String alarmId) {
        if (!this.alarmHashMap.containsKey(alarmId)) {
            throw new AlarmNotFoundException("No alarm with alarmId : " + alarmId + " exists");
        }
        Alarm alarm = this.alarmHashMap.get(alarmId);
        boolean isCancelled = alarm.getScheduledFuture().cancel(false);
        if (isCancelled) {
            System.out.println("Successfully cancelled alarm");
            alarm.setAlarmState(AlarmState.CANCELLED);
        } else {
            throw new AlarmCancellationError("Could not cancel alarm with id:" + alarmId);
        }
    }

    public HashMap<String, Alarm> getAlarmHashMap() {
        return alarmHashMap;
    }
}
