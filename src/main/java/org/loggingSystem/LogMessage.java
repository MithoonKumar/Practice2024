package org.loggingSystem;

public class LogMessage {
    private String message;
    private Long timeStamp;
    private LogLevel logLevel;

    public LogMessage(String message, Long timeStamp, LogLevel logLevel) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.logLevel = logLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }


    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                ", logLevel=" + logLevel +
                '}';
    }
}
