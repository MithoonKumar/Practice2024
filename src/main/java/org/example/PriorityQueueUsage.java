package org.example;

import java.util.PriorityQueue;

public class PriorityQueueUsage {
    public static void main(String[] args) {
        System.out.println("Hi");

        PriorityQueue<CustomClass> classPriorityQueue = new PriorityQueue<>();
        classPriorityQueue.add(new CustomClass(10, "Sachin"));
        classPriorityQueue.add(new CustomClass(1, "Sehwag"));
        classPriorityQueue.add(new CustomClass(2, "Dhoni"));
        classPriorityQueue.add(new CustomClass(-2, "Dinesh"));

        System.out.println(classPriorityQueue.peek().getName() + " " + classPriorityQueue.peek().getAge());

        classPriorityQueue.poll();

        System.out.println(classPriorityQueue.peek().getName() + " " + classPriorityQueue.peek().getAge());

    }
}


class CustomClass implements Comparable<CustomClass>{
    private int age;
    private String name;

    public CustomClass(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(CustomClass o) {
        if (this.age == o.age) {
            return 0;
        }
        return this.age < o.age ? 1 : -1;
    }
}