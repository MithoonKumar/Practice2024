package uber;

import java.util.concurrent.Future;

public class Alarm {
    String alarmId;
    AlarmType alarmType;
    AlarmState alarmState;
    Long duration;
    Long executionTime;
    Future<?> alarmFuture;


    public Alarm(String alarmId, AlarmType alarmType, Long duration) {
        this.alarmId = alarmId;
        this.alarmType = alarmType;
        this.alarmState = AlarmState.SCHEDULED;
        this.duration = duration;
        this.executionTime = System.currentTimeMillis() + this.duration;
    }

    public void cancelAlarm() {
        this.alarmState = AlarmState.CANCELLED;
    }

    public void setAlarmFuture(Future<?> alarmFuture) {
        this.alarmFuture = alarmFuture;
    }
}