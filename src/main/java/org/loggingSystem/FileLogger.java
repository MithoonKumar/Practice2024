package org.loggingSystem;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {

    private String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    public void log(LogMessage logMessage) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(logMessage.toString() + "\n");
            fileWriter.flush();
            System.out.println(filePath);
            System.out.println("Write successful");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
