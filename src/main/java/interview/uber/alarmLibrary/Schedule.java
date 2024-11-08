package interview.uber.alarmLibrary;

public class Schedule {
    private int repeatDuration;
    private int initialDelay;

    public Schedule(int repeatDuration, int initialDelay) {
        this.repeatDuration = repeatDuration;
        this.initialDelay = initialDelay;
    }

    public Schedule(int initialDelay) {
        this.initialDelay = initialDelay;
    }

    public int getRepeatDuration() {
        return repeatDuration;
    }

    public int getInitialDelay() {
        return initialDelay;
    }
}
