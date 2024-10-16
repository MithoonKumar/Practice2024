package org.MultiLevelCache;

public class LevelCacheMetaData {
    private Integer readTime;
    private Integer writeTime;

    public LevelCacheMetaData(Integer readTime, Integer writeTime) {
        this.readTime = readTime;
        this.writeTime = writeTime;
    }

    public Integer getReadTime() {
        return readTime;
    }

    public void setReadTime(Integer readTime) {
        this.readTime = readTime;
    }

    public Integer getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Integer writeTime) {
        this.writeTime = writeTime;
    }
}
