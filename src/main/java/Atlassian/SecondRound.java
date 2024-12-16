package Atlassian;

import java.util.HashMap;
import java.util.Objects;
import java.util.TreeSet;

public class SecondRound {
    /*
        Imagine you are given a stream of data points consisting of <timestamp, commodityPrice> you are supposed to return the maxCommodityPrice at any point in time.

The timestamps in the stream can be out of order, or there can be duplicate timestamps, we need to update the commodityPrice at that particular timestamp if an entry for the timestamp already exists.

Create an in-memory solution tailored to prioritize frequent reads and writes for the given problem statement.

    TreeSet<Tuple> tupleSet;
    HashMap<int, Tuple> map;
    (6, 21), (4, 24), (9, 25)

    4, 27
    6, 26
    9, 25
    get //27
    4, 24
    get // 26
    6, 21
    get// 25

    Add a method int getCommodityPrice(int timestamp, int checkpoint) that provides a mechanism to manage and query commodity prices at specific timestamps, associating each update with a unique checkpoint identifier. It allows for tracking and retrieving historical commodity prices corresponding to different checkpoints.

Every upsert operation is associated with a unique checkpoint, for more details let’s look at the sample code below

    */
    public static void main(String[] args) {
        RunningCommodityPriceImpl runningCommodityPrice = new RunningCommodityPriceImpl();
        runningCommodityPrice.upsertCommodityPrice(4, 27);
        runningCommodityPrice.upsertCommodityPrice(6, 26);
        runningCommodityPrice.upsertCommodityPrice(9, 25);
        System.out.println(runningCommodityPrice.getMaxCommodityPrice());
        runningCommodityPrice.upsertCommodityPrice(4, 24);
        System.out.println(runningCommodityPrice.getMaxCommodityPrice());
        runningCommodityPrice.upsertCommodityPrice(6, 21);
        System.out.println(runningCommodityPrice.getMaxCommodityPrice());
    }
}

class RunningCommodityPriceImpl implements RunningCommodityPrice1 {

    private TreeSet<Tuple> treeSet;
    private HashMap<Integer, Tuple> hashMap;

    public RunningCommodityPriceImpl() {
        this.treeSet = new TreeSet<>();
        this.hashMap = new HashMap<>();
    }

    @Override
    public int upsertCommodityPrice(int timestamp, int commodityPrice) {
        if (this.hashMap.containsKey(timestamp)) {
            Tuple tuple = this.hashMap.get(timestamp);
            treeSet.remove(tuple);
            tuple.setCommodityPrice(commodityPrice);
            treeSet.add(tuple);
        } else {
            Tuple tuple = new Tuple(timestamp, commodityPrice);
            treeSet.add(tuple);
            hashMap.put(timestamp, tuple);
        }

        return timestamp;
    }

    @Override
    public int getCommodityPrice(int timestamp, int checkpoint) {
        return 0;
    }

    @Override
    public int getMaxCommodityPrice() {
        if (!treeSet.isEmpty()) {
            return treeSet.getLast().getCommodityPrice();
        } else {
            throw new RuntimeException("No element in the stream");
        }
    }
}

class Tuple implements Comparable<Tuple>{
    private int timeStamp;
    private int commodityPrice;

    public int getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(int commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public Tuple(int timeStamp, int commodityPrice) {
        this.commodityPrice = commodityPrice;
        this.timeStamp = timeStamp;
    }

    @Override
    public int compareTo(Tuple o) {
        if (this.commodityPrice > o.commodityPrice) {
            return 1;
        } else if (this.commodityPrice < o.commodityPrice) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return timeStamp == tuple.timeStamp && commodityPrice == tuple.commodityPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeStamp, commodityPrice);
    }
}


interface RunningCommodityPrice1 {

    int upsertCommodityPrice(int timestamp, int commodityPrice);  // returns checkpoint id

    int getCommodityPrice(int timestamp, int checkpoint);  // returns commodity price at check point for timestamp

    int getMaxCommodityPrice();
}
/*
private HashMap<Integer, Integer> hashMap;

HashMap<Integer, HashMap<Integer, Integer>> snapShotMap;
14, 27
1, <(14, 27)>

16, 26
2, <(14, 27),(16, 26)>
19, 25
3, <(14, 27),(16, 26), (19, 25)>
14, 24
        4, <(14, 24),(16, 26), (19, 25)>
16, 23
        5, <(14, 24),(16, 23), (19, 25)>
14, 20
        6, <(14, 20),(16, 23), (19, 25)>

RunningCommodityPrice r = new RunningCommodityPrice();

int firstCheckpoint = r.upsertCommodityPrice(14, 27);

int secondCheckpoint = r.upsertCommodityPrice(16, 26);

int thirdCheckpoint = r.upsertCommodityPrice(19, 25);

int fourthCheckpoint = r.upsertCommodityPrice(14, 24);

int fifthCheckpoint = r.upsertCommodityPrice(16, 23);

int sixthCheckpoint = r.upsertCommodityPrice(14, 20);

r.getCommodityPrice(14, fifthCheckpoint);    // returns 24

// since price at timestamp 14 got updated to 24 on or before fifthCheckpoint

r.getCommodityPrice(14, secondCheckpoint);   // returns 27

// since price at timestamp 14 got updated to 27 on or before secondCheckpoint




r.getCommodityPrice(16, sixthCheckpoint);    // returns 23

// since price at timestamp 16 got updated 23 either on or before sixthCheckpoint

*/