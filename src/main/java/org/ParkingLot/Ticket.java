package org.ParkingLot;

public class Ticket {
    private String ticketId;
    private String VehicleNumber;
    private Long entryTime;
    private ParkingSpot parkingSpot;

    public Ticket(String ticketId, String vehicleNumber, Long entryTime, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        VehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public Long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Long entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
