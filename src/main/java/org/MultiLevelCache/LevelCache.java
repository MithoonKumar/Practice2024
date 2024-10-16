package org.MultiLevelCache;


import java.util.Objects;

public class LevelCache<K,V > implements IlevelCache<K, V>{

    private Icache<K, V> icache;
    private IlevelCache<K, V> nextLevelCache;
    private LevelCacheMetaData levelCacheMetaData;

    public LevelCache(Integer cacheSize, IlevelCache<K, V> nextLevelCache, LevelCacheMetaData levelCacheMetaData) {
        this.icache = new LRUCache<>(cacheSize);
        this.nextLevelCache = nextLevelCache;
        this.levelCacheMetaData = levelCacheMetaData;
    }

    @Override
    public ReadInfo<V> get(K k) {
        V value = this.icache.get(k);
        ReadInfo<V> readInfo = new ReadInfo<V>(this.levelCacheMetaData.getReadTime(), value);
        if (value == null) {
            ReadInfo<V> readInfoFromNextLevel = new ReadInfo<>(0, null);
            if (this.nextLevelCache != null) {
                readInfoFromNextLevel = this.nextLevelCache.get(k);
            }
            readInfo.setReadTime(readInfo.getReadTime() + readInfoFromNextLevel.getReadTime());
            if (readInfoFromNextLevel.getValue() != null) {
                this.icache.put(k, readInfoFromNextLevel.getValue());
                readInfo.setReadTime(readInfo.getReadTime()  + this.levelCacheMetaData.getWriteTime());
            }
        }
        return readInfo;
    }

    @Override
    public WriteInfo put(K k, V v) {
        V value = this.icache.get(k);
        WriteInfo writeInfo = new WriteInfo(this.levelCacheMetaData.getReadTime());
        if (value != null) {
            if (!Objects.equals(value, v)) {
                this.icache.put(k, v);
                writeInfo.setWriteTime(writeInfo.getWriteTime() + this.levelCacheMetaData.getWriteTime());
                WriteInfo writeInfoFromNextLevel = new WriteInfo(0);
                if (this.nextLevelCache != null) {
                    writeInfoFromNextLevel = this.nextLevelCache.put(k, v);
                }
                writeInfo.setWriteTime(writeInfo.getWriteTime() + writeInfoFromNextLevel.getWriteTime());
            }
        } else {
            this.icache.put(k, v);
            writeInfo.setWriteTime(writeInfo.getWriteTime() + this.levelCacheMetaData.getWriteTime());
            WriteInfo writeInfoFromNextLevel = new WriteInfo(0);
            if (this.nextLevelCache != null) {
                writeInfoFromNextLevel = this.nextLevelCache.put(k, v);
            }
            writeInfo.setWriteTime(writeInfo.getWriteTime() + writeInfoFromNextLevel.getWriteTime());
        }
        return writeInfo;
    }
}
