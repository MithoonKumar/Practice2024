package org.loggingSystem;

public class Main {

    public static void main(String[] args) {
        Logger logger = new Logger(LogLevel.DEBUG, "/Users/mithoonkumar/IdeaProjects/Practice_2024/src/main/java/org/loggingSystem/test.txt");

        System.out.println("Hello, I will start logging from here");

        logger.log(LogLevel.DEBUG, "Hi! This is a sample debug logging");
        logger.log(LogLevel.ERROR, "Hi! This is a sample error logging");
    }
}
