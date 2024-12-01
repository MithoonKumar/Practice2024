package Salesforce;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BookingManager {

    private BikeRepo bikeRepo;
    HashMap<String, Booking> bookingHashMap;

    public BookingManager(BikeRepo bikeRepo) {
        this.bikeRepo = bikeRepo;
        bookingHashMap = new HashMap<>();
    }

    public Bike getFreeBike() {
        HashMap<String, Bike> bikeHashMap = this.bikeRepo.getBikesMap();

        for (Map.Entry<String, Bike> bike: bikeHashMap.entrySet()) {
            if (bike.getValue().getBikeBookingStatus().equals(BikeBookingStatus.FREE)) {
                return bike.getValue();
            }
        }
        return  null;
    }


    public Booking bookBike (String userId, Bike bike, Long startTime) {
        bike.setBikeBookingStatus(BikeBookingStatus.BOOKED);
        String bookingId = UUID.randomUUID().toString();

        Booking booking = new Booking(bookingId, startTime, userId, bike.getBikeId());
        this.bookingHashMap.put(bookingId,  booking);
        return booking;
    }

    public void returnBike(String bookingId) {
        Booking booking = this.bookingHashMap.get(bookingId);
        this.bikeRepo.getBikesMap().get(booking.getBikeId()).setBikeBookingStatus(BikeBookingStatus.FREE);
        booking.setEndTime(System.currentTimeMillis());
    }
}
