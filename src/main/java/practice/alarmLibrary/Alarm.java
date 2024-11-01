package practice.alarmLibrary;

import java.util.concurrent.ScheduledFuture;

public class Alarm {
    private AlarmType alarmType;
    private Schedule schedule;
    private Runnable alarmTask;
    private ScheduledFuture<?> scheduledFuture;

    public Alarm(Schedule schedule, AlarmType alarmType, Runnable alarmTask, ScheduledFuture<?> scheduledFuture) {
        this.alarmType = alarmType;
        this.schedule = schedule;
        this.alarmTask = alarmTask;
        this.scheduledFuture = scheduledFuture;
    }

    public ScheduledFuture<?> getScheduledFuture() {
        return scheduledFuture;
    }
}
