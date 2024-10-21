package org.rideSharingApp;

import java.util.ArrayList;
import java.util.List;

public class RideMatcher {
    private List<Driver> driverList;

    public RideMatcher(List<Driver> driverList) {
        this.driverList = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        this.driverList.add(driver);
    }

    public Driver findDriver(User user) {
        for (Driver driver: driverList) {
            if (driver.isAvailable()) {
                if (Math.abs(driver.getLocation().getLatitude()- user.getLocation().getLatitude()) <=2 &&
                    Math.abs(driver.getLocation().getLongitude()- user.getLocation().getLongitude()) <=2) {
                    driver.setAvailable(false);
                    return driver;
                }
            }
        }
        throw new RideSharingAppException("No drivers available");
    }
}
