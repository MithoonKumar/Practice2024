package org.loggingSystem;


public class Logger {
    private LogLevel logLevel;
    private ConsoleLogger consoleLogger;
    private FileLogger fileLogger;

    public Logger(LogLevel logLevel, String filePath) {
        this.logLevel = logLevel;
        this.consoleLogger = new ConsoleLogger();
        this.fileLogger = new FileLogger(filePath);
    }

    public void log(LogLevel level, String message) {
        if (level.ordinal() >= this.logLevel.ordinal()) {
            LogMessage logMessage = new LogMessage(message, System.currentTimeMillis(), level);
            this.consoleLogger.log(logMessage);
            this.fileLogger.log(logMessage);
        }
    }

}
