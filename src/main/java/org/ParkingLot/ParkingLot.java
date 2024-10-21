package org.ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ParkingLot {
    private List<ParkingFloor> parkingFloorList;
    private ParkingStrategy parkingStrategy;
    private Map<String, Ticket> ticketMap;
    private NotificationService notificationService;

    public ParkingLot(List<ParkingFloor> parkingFloorList, ParkingStrategy parkingStrategy) {
        this.parkingFloorList = parkingFloorList;
        this.parkingStrategy = parkingStrategy;
        this.ticketMap = new HashMap<>();
        this.notificationService = new NotificationService();
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloorList.add(parkingFloor);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = this.parkingStrategy.findParkingSpot(this.parkingFloorList, vehicle);
        if (parkingSpot != null) {
            parkingSpot.setOccupied(true);
        } else {
            throw new ParkingLotExcpetion("No parking slot is free");
        }
        String ticketId = generateTicketId();
        Ticket ticket = new Ticket(ticketId, vehicle.getVehicleNumber(), System.currentTimeMillis(), parkingSpot);
        ticketMap.put(vehicle.getVehicleNumber(), ticket);
        this.notificationService.scheduleNotificationWithDelay(vehicle.getVehicleNumber(), 5000L, TimeUnit.MILLISECONDS);
        return ticket;
    }

    public void leaveVehicle(String vehicleNumber) {
        Ticket ticket = ticketMap.get(vehicleNumber);
        if (ticket != null) {
            ParkingSpot parkingSpot = ticket.getParkingSpot();
            parkingSpot.setOccupied(false);
            ticketMap.remove(vehicleNumber);
        } else {
            throw new ParkingLotExcpetion("No vehicle parked with the given number");
        }
    }

    private String generateTicketId() {
        return "TICKET" + (ticketMap.size() + 1);
    }
}
