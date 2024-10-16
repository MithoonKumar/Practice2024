package org.example;

public class ThreadUsage extends Thread {

    @Override
    public void run() {
        System.out.println("This logging is from the thread" + Thread.currentThread().threadId());
    }

    public static void main(String[] args) {
        ThreadUsage threadUsage1 = new ThreadUsage();
        ThreadUsage threadUsage2 = new ThreadUsage();
        threadUsage1.start();
        threadUsage2.start();
    }
}
