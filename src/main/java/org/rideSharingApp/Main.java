package org.rideSharingApp;

/*
User
Rider
Driver
Ride
Location
Vehicle




*/


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create some locations
        Location userLocation = new Location(10, 20);
        Location driverLocation = new Location(12, 22);

        // Create a vehicle for the driver
        Vehicle vehicle = new Vehicle(4, "ABC1234");

        // Create a driver and a user
        Driver driver = new Driver("driver1", "John Doe", "john@example.com", "1234567890", 4.5, driverLocation, vehicle);
        User user = new User("user1", "Jane Smith", "jane@example.com", "0987654321", 4.0, userLocation);

        // Create a RideMatcher and add the driver
        List<Driver> driverList = new ArrayList<>();
        RideMatcher rideMatcher = new RideMatcher(driverList);
        rideMatcher.addDriver(driver);

        // Try to find a driver for the user
        try {
            Driver matchedDriver = rideMatcher.findDriver(user);
            System.out.println("Driver " + matchedDriver.getName() + " has been matched with user " + user.getName());

            // Create a Ride
            Ride ride = new Ride(user, matchedDriver, user.getLocation(), driver.getLocation(), RideStatus.PENDING);
            ride.setStartTime(System.currentTimeMillis()); // Start the ride
            ride.setRideStatus(RideStatus.ONGOING); // Update ride status
            System.out.println("Ride status: " + ride.getRideStatus());

            // Simulate ride duration
            // After some time, end the ride
            ride.setEndTime(System.currentTimeMillis());
            ride.setRideStatus(RideStatus.COMPLETED); // Update ride status
            matchedDriver.setAvailable(true); // Mark the driver as available
            System.out.println("Ride started at: " + ride.getStartTime() + " and ended at: " + ride.getEndTime());
            System.out.println("Final ride status: " + ride.getRideStatus());
            System.out.println("Driver " + matchedDriver.getName() + " is now available for new rides.");

        } catch (RideSharingAppException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
