package org.MultiLevelCache;

public interface IlevelCache <K,V> {

    ReadInfo<V> get(K k);
    WriteInfo put(K k, V v);

}
