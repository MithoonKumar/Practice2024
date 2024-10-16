package org.MultiLevelCache;

public interface Icache<K, V> {

    void put(K k, V v);
    V get(K k);
    void evict();

}
