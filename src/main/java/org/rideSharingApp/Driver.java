package org.rideSharingApp;

public class Driver extends User {

    private Vehicle vehicle;
    private boolean isAvailable;

    public Driver(String userId, String name, String email, String phoneNumber, double rating, Location location, Vehicle vehicle) {
        super(userId, name, email, phoneNumber, rating, location);
        this.vehicle = vehicle;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
