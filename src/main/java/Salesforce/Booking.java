package Salesforce;

public class Booking {

    private String userId;
    private String bookingId;
    private String bikeId;
    private Long startTime;
    private Long endTime;

    public Booking(String bookingId, Long startTime, String userId, String bikeId) {
        this.bookingId = bookingId;
        this.startTime = startTime;
        this.userId = userId;
        this.bikeId = bikeId;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getBikeId() {
        return bikeId;
    }

    public String getBookingId() {
        return bookingId;
    }
}
