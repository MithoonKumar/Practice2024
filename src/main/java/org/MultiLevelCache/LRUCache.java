package org.MultiLevelCache;

import java.util.LinkedHashMap;

public class LRUCache <K, V> implements Icache<K, V> {

    private final Integer capacity;
    private final LinkedHashMap<K, V> linkedHashMap;

    public LRUCache(Integer capacity) {
        this.capacity = capacity;
        this.linkedHashMap = new LinkedHashMap<>();
    }

    @Override
    public void put(K k, V v) {
        if (this.linkedHashMap.containsKey(k)) {
            this.linkedHashMap.remove(k);
            this.linkedHashMap.put(k, v);
        } else {
            if (this.linkedHashMap.size() < this.capacity) {
                this.linkedHashMap.put(k, v);
            } else {
                evict();
                this.linkedHashMap.put(k, v);
            }
        }

    }

    @Override
    public V get(K k) {
        if (this.linkedHashMap.containsKey(k)) {
            V v = this.linkedHashMap.get(k);
            this.linkedHashMap.remove(k);
            this.linkedHashMap.put(k, v);
            return v;
        } else {
            return null;
        }
    }

    @Override
    public void evict() {
        this.linkedHashMap.pollFirstEntry();
    }
}
