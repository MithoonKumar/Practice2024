package org.example;

import java.util.HashSet;

public class UsageOfHashSet {

    public static void main(String[] args) {
        System.out.println("Hello from hashset");

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("First");
        hashSet.add("Second");
        hashSet.add("Third");
        hashSet.add("Fourth");
        hashSet.add("Fifth");

        System.out.println(hashSet.contains("Sixth"));
        System.out.println(hashSet.contains("Fifth"));

        hashSet.forEach(System.out::println);

        hashSet.forEach(System.out::println);
    }
}
