package org.parking.model;

public class Vehicle {
    private StringBuilder licensePlate;
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

    public Vehicle(StringBuilder licensePlate, vehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public StringBuilder getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(StringBuilder licensePlate) {
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
