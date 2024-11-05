package interview.wayfair;

public class VolumeBasedCostCalculationStrategy implements ICostCalculationStrategy{

    @Override
    public int getCost(IPackage iPackage) {
        int volume = iPackage.getHeight() * iPackage.getWidth() * iPackage.getLength();
        if (volume <= 1000) {
            return 10;
        } else if (volume <= 10000) {
            return 100;
        } else {
            return 500;
        }
    }
}
