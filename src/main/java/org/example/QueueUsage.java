package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUsage {

    public static void main(String[] args) {
        System.out.println("Hello from Queue");
        Queue<String> queue = new LinkedList<>();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
