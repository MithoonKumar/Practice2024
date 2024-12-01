package org.practice.alarmLibrary;

public class AlarmNotFoundException extends RuntimeException {

    public AlarmNotFoundException(String message) {
        super(message);
    }
}
