package org.loggingSystem;

public class ConsoleLogger {

    public void log(LogMessage logMessage) {
        System.out.println(logMessage.toString());
    }
}
