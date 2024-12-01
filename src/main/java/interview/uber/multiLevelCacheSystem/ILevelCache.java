package interview.uber.multiLevelCacheSystem;

public interface ILevelCache <K,V>{
    ReadInfo<V> get(K k);
    WriteInfo put(K k, V v);
}


