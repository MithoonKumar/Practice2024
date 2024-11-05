package interview.wayfair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cargo implements IShipment {
    private List<IPackage> packages;
    private ICostCalculationStrategy costCalculationStrategy;
    
    

    public Cargo(ICostCalculationStrategy costCalculationStrategy) {
        this.packages = new ArrayList<>();
        this.costCalculationStrategy = costCalculationStrategy;
    }

    @Override
    public void insert(IPackage iPackage) {
        if (this.packages.stream().anyMatch(pkg -> pkg.getPackageId() == iPackage.getPackageId())) {
            throw new CargoManagmentException("Package already exists with the given id");
        }
        this.packages.add(iPackage);
    }

    @Override
    public void remove(int id) {
        boolean removed = this.packages.removeIf((pkg) -> pkg.getPackageId() == id);
        if (!removed) {
            throw new CargoManagmentException("Package not found");
        }

    }

    @Override
    public int getTotalCost() {
        int cost = 0;
        for (IPackage pkg: packages) {
            cost+=this.costCalculationStrategy.getCost(pkg);
        }
        return cost;
    }

    @Override
    public Map<Category, Integer> getCategoryWiseCosts() {
        Map<Category, Integer> categoryCostMap = new HashMap<>();
        for (IPackage pkg: packages) {
            categoryCostMap.put(pkg.getCategory(), categoryCostMap.getOrDefault(pkg.getCategory(), 0)+ this.costCalculationStrategy.getCost(pkg));
        }
        return categoryCostMap;
    }
    
    
}
