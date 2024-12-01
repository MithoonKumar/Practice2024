package interview.uber.multiLevelCacheSystem;

public interface ICache<K,V> {
    V get(K k);
    void put(K k, V v);
    void evict(K k);
}
