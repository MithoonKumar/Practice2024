package org.ParkingLot;

import java.util.List;

public class ClosestAvailableParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findParkingSpot(List<ParkingFloor> parkingFloorList, Vehicle vehicle) {
        for (ParkingFloor parkingFloor: parkingFloorList) {
            for (ParkingSpot parkingSpot: parkingFloor.getParkingSpotList()) {
                if (!parkingSpot.getOccupied() && parkingSpot.canFitVehicle(vehicle.getVehicleType())) {
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
