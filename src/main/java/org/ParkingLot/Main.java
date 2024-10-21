package org.ParkingLot;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        ParkingSpot parkingSpot1 = new ParkingSpot(ParkingSpotType.LARGE, false);
        ParkingSpot parkingSpot2 = new ParkingSpot(ParkingSpotType.COMPACT, false);
        ParkingSpot parkingSpot3 = new ParkingSpot(ParkingSpotType.LARGE, false);
        ParkingSpot parkingSpot4 = new ParkingSpot(ParkingSpotType.COMPACT, false);

        ParkingFloor parkingFloor1 = new ParkingFloor();
        parkingFloor1.addParkingSpot(parkingSpot1);
        parkingFloor1.addParkingSpot(parkingSpot2);

        ParkingFloor parkingFloor2 = new ParkingFloor();
        parkingFloor2.addParkingSpot(parkingSpot3);
        parkingFloor2.addParkingSpot(parkingSpot4);
        ParkingStrategy parkingStrategy = new ClosestAvailableParkingStrategy();

        ParkingLot parkingLot = new ParkingLot(List.of(parkingFloor1, parkingFloor2), parkingStrategy);


        Vehicle vehicle1 = new Vehicle("1", VehicleType.TRUCK);
        Vehicle vehicle2 = new Vehicle("2", VehicleType.TRUCK);
        Vehicle vehicle3 = new Vehicle("3", VehicleType.TRUCK);

        parkingLot.parkVehicle(vehicle1);
        parkingLot.parkVehicle(vehicle2);
        parkingLot.parkVehicle(vehicle3);

    }
}
