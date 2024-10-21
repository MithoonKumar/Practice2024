package org.ParkingLot;

import java.util.List;

public interface ParkingStrategy {

    ParkingSpot findParkingSpot(List<ParkingFloor> parkingFloorList, Vehicle vehicle);

}
