package Atlassian;

public interface RunningCommodityPrice {

    void upsertCommodityPrice(int timestamp, int commodityPrice);



    int getMaxCommodityPrice();

}