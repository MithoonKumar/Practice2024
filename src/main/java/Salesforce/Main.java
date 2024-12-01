package Salesforce;

import java.util.UUID;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BikeRepo bikeRepo = new BikeRepo();
        BikeInventoryManager bikeInventoryManager = new BikeInventoryManager(bikeRepo);
        String bikeId = UUID.randomUUID().toString();
        bikeInventoryManager.addBike(new Bike(bikeId));

        BookingManager bookingManager = new BookingManager(bikeRepo);

        Bike bike = bookingManager.getFreeBike();
        System.out.println(bike.getBikeId());

        String userId = "123";
        Booking booking = bookingManager.bookBike(userId, bike, System.currentTimeMillis());

        Bike newBike = bookingManager.getFreeBike();
        System.out.println(newBike);


        bookingManager.returnBike(booking.getBookingId());


        Bike newBike1 = bookingManager.getFreeBike();
        System.out.println(newBike1.getBikeId());


    }
}
