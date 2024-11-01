package practice.alarmLibrary;

import java.util.concurrent.TimeUnit;

public class Schedule {
    private Long initialDelay;
    private Long repeatDuration;
    private TimeUnit timeUnit;

    public Schedule(Long initialDelay, Long repeatDuration, TimeUnit timeUnit) {
        this.initialDelay = initialDelay;
        this.repeatDuration = repeatDuration;
        this.timeUnit = timeUnit;
    }

    public Long getRepeatDuration() {
        return repeatDuration;
    }

    public Long getInitialDelay() {
        return initialDelay;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

}
