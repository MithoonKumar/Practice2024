package org.MultiLevelCache;

public class ReadInfo<V> {
    private Integer readTime;
    private V value;

    public ReadInfo(Integer readTime, V value) {
        this.readTime = readTime;
        this.value = value;
    }

    public Integer getReadTime() {
        return readTime;
    }

    public void setReadTime(Integer readTime) {
        this.readTime = readTime;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
