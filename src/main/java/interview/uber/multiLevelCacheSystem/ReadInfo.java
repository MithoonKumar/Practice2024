package interview.uber.multiLevelCacheSystem;

public class ReadInfo<V> {
    private int readTime;
    private V v;

    public ReadInfo() {
    }

    public ReadInfo(int readTime, V v) {
        this.readTime = readTime;
        this.v = v;
    }

    public void setReadTime(int readTime) {
        this.readTime = readTime;
    }

    public void setV(V v) {
        this.v = v;
    }

    public V getV() {
        return v;
    }

    public int getReadTime() {
        return readTime;
    }
}
