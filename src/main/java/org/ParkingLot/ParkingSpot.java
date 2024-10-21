package org.ParkingLot;

public class ParkingSpot {
    private ParkingSpotType parkingSpotType;
    private Boolean isOccupied;

    public ParkingSpot(ParkingSpotType parkingSpotType, Boolean isOccupied) {
        this.parkingSpotType = parkingSpotType;
        this.isOccupied = isOccupied;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    public boolean canFitVehicle(VehicleType vehicleType) {
        return switch (this.parkingSpotType) {
            case ParkingSpotType.COMPACT -> vehicleType == VehicleType.CAR || vehicleType == VehicleType.MOTORBIKE;
            case ParkingSpotType.LARGE -> vehicleType == VehicleType.TRUCK;
        };
    }
}
