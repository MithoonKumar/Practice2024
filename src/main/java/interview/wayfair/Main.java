package interview.wayfair;

public class Main {

    public static void main(String[] args) {
        ICostCalculationStrategy costCalculationStrategy = new VolumeBasedCostCalculationStrategy();
        IShipment shipment = new Cargo(costCalculationStrategy);

        // Creating and adding packages
        IPackage package1 = new Package(1, "Phone", 20, 1, 15, 15);
        IPackage package2 = new Package(2, "Laptop", 50, 5, 40, 30);
        IPackage package3 = new Package(3, "Desktop", 80, 10, 60, 40);

        shipment.insert(package1);
        shipment.insert(package2);
        shipment.insert(package3);

        // Calculate and print total cost
        System.out.println("Total Cost: " + shipment.getTotalCost());

        // Print category-wise costs
        System.out.println("Category-wise Costs: " + shipment.getCategoryWiseCosts());

        // Testing removal of a package and recalculating costs
        shipment.remove(2); // Removing "Laptop"
        System.out.println("Total Cost after removal: " + shipment.getTotalCost());
        System.out.println("Category-wise Costs after removal: " + shipment.getCategoryWiseCosts());

        // Edge Case: Removing a package that doesn't exist
        try {
            shipment.remove(10); // Non-existing package ID
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Edge Case: Inserting duplicate ID package
        try {
            shipment.insert(package1); // Attempt to re-insert package1
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

}
