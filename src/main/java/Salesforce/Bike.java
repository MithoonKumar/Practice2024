package Salesforce;

public class Bike {
    private String bikeId;
    private BikeBookingStatus bikeBookingStatus;

    public Bike(String bikeId) {
        this.bikeId = bikeId;
        this.bikeBookingStatus = BikeBookingStatus.FREE;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public BikeBookingStatus getBikeBookingStatus() {
        return bikeBookingStatus;
    }

    public void setBikeBookingStatus(BikeBookingStatus bikeBookingStatus) {
        this.bikeBookingStatus = bikeBookingStatus;
    }
}
