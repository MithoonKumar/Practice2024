package interview.wayfair;

import java.util.Map;

public interface IShipment {
    void insert (IPackage iPackage);
    void remove (int id);
    int getTotalCost();
    Map<Category, Integer> getCategoryWiseCosts();
}
