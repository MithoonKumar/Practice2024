package org.example;

import java.util.HashMap;
import java.util.Map;

public class UsageOfHashMap {

    public static void main(String[] args) {
        System.out.println("Usage of hashmap");
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("first", 1);
        hashMap.put("second", 2);
        hashMap.put("third", 3);

        System.out.println(hashMap.get("first"));

        for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        hashMap.forEach( (key, val) -> {
            System.out.println(key);
            System.out.println(val);
        });
    }
}
