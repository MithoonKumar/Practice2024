package interview.uber.multiLevelCacheSystem;

public class LevelCache<K, V> implements ILevelCache<K, V>{

    private int readTime;
    private int writeTime;

    private ILevelCache<K,V> nextLevelCache;
    private ICache<K, V> iCache;

    public LevelCache(ILevelCache<K, V> nextLevelCache, int readTime, int writeTime, ICache<K, V> iCache) {
        this.nextLevelCache = nextLevelCache;
        this.readTime = readTime;
        this.writeTime = writeTime;
        this.iCache = iCache;
    }

    @Override
    public ReadInfo<V> get(K k) {
        ReadInfo<V> readInfo = new ReadInfo<V>();
        V value = this.iCache.get(k);
        if (value != null) {
            readInfo.setReadTime(this.readTime);
            readInfo.setV(value);
            return readInfo;
        } else {
            ReadInfo<V> readInfoFromNextLevel;
            if (this.nextLevelCache == null) {
                readInfo.setV(value);
                readInfo.setReadTime(this.readTime);
                return readInfo;
            } else {
                readInfoFromNextLevel = this.nextLevelCache.get(k);
                if (readInfoFromNextLevel.getV() != null) {
                    this.iCache.put(k, readInfoFromNextLevel.getV());
                    readInfo.setV(readInfoFromNextLevel.getV());
                    readInfo.setReadTime(readInfoFromNextLevel.getReadTime() + this.writeTime + this.readTime);
                } else {
                    readInfo.setReadTime(readInfoFromNextLevel.getReadTime() + this.readTime);
                }
                return readInfo;
            }
        }

    }

    @Override
    public WriteInfo put(K k, V v) {
        V value = this.iCache.get(k);
        WriteInfo writeInfo = new WriteInfo(0);
        writeInfo.setWriteTime(writeInfo.getWriteTime() + this.readTime);
        if ((value == null) || (value != v)) {
            this.iCache.put(k, v);
            writeInfo.setWriteTime(writeInfo.getWriteTime() + this.writeTime);
        }
        WriteInfo nextLevelWriteInfo;
        if (this.nextLevelCache == null) {
            return writeInfo;
        } else {
            nextLevelWriteInfo = this.nextLevelCache.put(k, v);
            writeInfo.setWriteTime(writeInfo.getWriteTime() + nextLevelWriteInfo.getWriteTime());
            return writeInfo;
        }
    }
}
