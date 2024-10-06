package org.example;

import java.util.TreeMap;

public class UsageOfTreeMap {

    public static void main(String[] args) {
        System.out.println("Hello from tree map");
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(1, "One");
        treeMap.put(12, "Twelve");
        treeMap.put(3, "Three");
        treeMap.put(5, "Five");
        System.out.println(treeMap);

        System.out.println(treeMap.containsKey(122));

        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.lastKey());

        System.out.println(treeMap.headMap(6).size());

        System.out.println(treeMap.tailMap(6));
    }
}
