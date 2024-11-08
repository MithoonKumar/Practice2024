package interview.uber.alarmLibrary;

import java.util.concurrent.ScheduledFuture;

public class Alarm {
    private String alarmId;
    private Schedule schedule;
    private AlarmType alarmType;
    private AlarmState alarmState;
    private Runnable alarmTask;
    private ScheduledFuture<?> scheduledFuture;

    public Alarm(String alarmId, Schedule schedule, AlarmType alarmType, AlarmState alarmState, Runnable alarmTask) {
        this.alarmId = alarmId;
        this.schedule = schedule;
        this.alarmType = alarmType;
        this.alarmState = alarmState;
        this.alarmTask = alarmTask;
    }

    public void setScheduledFuture(ScheduledFuture<?> scheduledFuture) {
        this.scheduledFuture = scheduledFuture;
    }

    public AlarmState getAlarmState() {
        return alarmState;
    }

    public synchronized void setAlarmState(AlarmState alarmState) {
        this.alarmState = alarmState;
    }

    public ScheduledFuture<?> getScheduledFuture() {
        return scheduledFuture;
    }

    public Runnable getAlarmTask() {
        return alarmTask;
    }

    public void execute() {
        this.alarmTask.run();
        setAlarmState(AlarmState.COMPLETED);
    }
}
