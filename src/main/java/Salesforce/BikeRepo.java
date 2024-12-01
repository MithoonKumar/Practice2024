package Salesforce;

import java.util.HashMap;

public class BikeRepo {

    private HashMap<String, Bike> bikesMap;

    public BikeRepo() {
        this.bikesMap = new HashMap<>();
    }

    public HashMap<String, Bike> getBikesMap() {
        return bikesMap;
    }
}
