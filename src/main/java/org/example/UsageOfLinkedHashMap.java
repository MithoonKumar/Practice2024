package org.example;

import java.util.LinkedHashMap;

public class UsageOfLinkedHashMap {

    public static void main(String[] args) {
        System.out.println("Hello from linkedHashMap");
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("first", 1);
        linkedHashMap.put("second", 2);
        linkedHashMap.put("third", 1);

        System.out.println(linkedHashMap.get("first"));
        linkedHashMap.remove("second");
        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap.firstEntry().getKey());
        System.out.println(linkedHashMap.lastEntry().getKey());
    }
}
