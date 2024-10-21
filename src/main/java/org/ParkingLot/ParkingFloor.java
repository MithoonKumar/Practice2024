package org.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> parkingSpotList;

    public ParkingFloor() {
        this.parkingSpotList = new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpotList.add(parkingSpot);
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }
}
