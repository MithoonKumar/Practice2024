package interview.uber.multiLevelCacheSystem;

import java.util.LinkedHashMap;

public class LRUCache<K, V> implements ICache<K, V>{

    private LinkedHashMap<K, V> linkedHashMap;
    private int capacity;

    public LRUCache(int capacity) {
        this.linkedHashMap = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    @Override
    public V get(K k) {
        V value;
        if (this.linkedHashMap.containsKey(k)) {
            value = this.linkedHashMap.get(k);
        } else {
            return null;
        }
        this.reAdjustPos(k, value);
        return value;
    }

    private void reAdjustPos(K k, V v) {
        this.linkedHashMap.remove(k);
        this.linkedHashMap.put(k, v);
    }

    @Override
    public void put(K k, V v) {
        if (this.linkedHashMap.containsKey(k)) {
            this.reAdjustPos(k, v);
        } else {
            if (this.linkedHashMap.size() == this.capacity) {
                this.evict(this.linkedHashMap.firstEntry().getKey());
                this.linkedHashMap.put(k, v);
            } else {
                this.linkedHashMap.put(k, v);
            }
        }
    }

    @Override
    public void evict(K k) {
        this.linkedHashMap.remove(k);
    }
}
