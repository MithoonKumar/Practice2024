package interview.uber.alarmLibrary;

public class AlarmCancellationError extends RuntimeException {
    public AlarmCancellationError(String message) {
        super(message);
    }
}
