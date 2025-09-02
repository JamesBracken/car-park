package org.parking.model;

public class Vehicle {
    private String licensePlate;
    private vehicleType type;

    public enum vehicleType {
        MOTORCYCLE,
        CAR,
        VAN
    };

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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate=" + licensePlate +
                ", type=" + type +
                '}';
    }
}
