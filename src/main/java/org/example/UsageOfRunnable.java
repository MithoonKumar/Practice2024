package org.example;

public class UsageOfRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("This logging is happening from a separate thread using runnable interface");
    }

    public static void main(String[] args) {
        UsageOfRunnable usageOfRunnable = new UsageOfRunnable();
        Thread thread = new Thread(usageOfRunnable);
        thread.start();
    }
}
