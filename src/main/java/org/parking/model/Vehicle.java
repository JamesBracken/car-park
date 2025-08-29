package org.parking.model;

public abstract class Vehicle {
    private String licensePlate;
    private vehicleType type;

    public enum vehicleType {
        MOTORCYCLE,
        CAR,
        VAN
    };

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public vehicleType getType() {
        return type;
    }

    public void setType(vehicleType type) {
        this.type = type;
    }

    public Vehicle(String licensePlate, vehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }
}
