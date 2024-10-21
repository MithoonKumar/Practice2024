package org.rideSharingApp;

public class Vehicle {
    private int capacity;
    private String regNumber;

    public Vehicle(int capacity, String regNumber) {
        this.capacity = capacity;
        this.regNumber = regNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}
