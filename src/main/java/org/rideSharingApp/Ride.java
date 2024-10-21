package org.rideSharingApp;

public class Ride {
    private User user;
    private Driver driver;
    private Location startLocation;
    private Location destinationLocation;
    private Long startTime;
    private Long endTime;
    private RideStatus rideStatus;


    public Ride(User user, Driver driver, Location startLocation, Location destinationLocation, RideStatus rideStatus) {
        this.user = user;
        this.driver = driver;
        this.startLocation = startLocation;
        this.destinationLocation = destinationLocation;
        this.rideStatus = rideStatus;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
