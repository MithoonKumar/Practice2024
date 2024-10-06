package org.example;

import java.util.LinkedList;

public class DoublyLinkedListUsage {

    public static void main(String[] args) {
        System.out.println("Hello from doubly linked list");
        LinkedList<String> dll = new LinkedList<>();
        dll.add("First");
        dll.add("Second");
        dll.add("Third");
        dll.addFirst("Zero");
        dll.addLast("Last");
        dll.add(5, "LastLast");
        System.out.println(dll);
        dll.removeFirst();
        System.out.println(dll);
        dll.removeLast();
        System.out.println(dll);
    }
}
