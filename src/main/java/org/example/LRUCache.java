package org.example;

import java.util.LinkedHashMap;

public class LRUCache {
    private  LinkedHashMap<String, String> linkedHashMap;
    private  Integer size;

    public LRUCache(Integer size) {
        this.linkedHashMap = new LinkedHashMap<>();
        this.size = size;
    }

    public static void main(String[] args) {


    }

    public  String get(String key) {
        if (linkedHashMap.containsKey(key)) {
            String val = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key, val);
            return val;
        }
        return null;
    }

    public  void put(String key, String value) {
        if (linkedHashMap.containsKey(key)) {
            String val = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key, val);
        } else {
            if (linkedHashMap.size() == size) {
                String firstKey = linkedHashMap.firstEntry().getKey();
                linkedHashMap.remove(firstKey);
            }
            linkedHashMap.put(key, value);
        }
    }
}
