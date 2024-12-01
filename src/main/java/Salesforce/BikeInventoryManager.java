package Salesforce;

public class BikeInventoryManager {

    private BikeRepo bikeRepo;

    public BikeInventoryManager(BikeRepo bikeRepo) {
        this.bikeRepo = bikeRepo;
    }

    public void addBike(Bike bike) {
        this.bikeRepo.getBikesMap().put(bike.getBikeId(), bike);
    }
}
