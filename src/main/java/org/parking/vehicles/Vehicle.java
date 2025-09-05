package org.parking.vehicles;

public class Vehicle {
    private final String licensePlate;
    private final vehicleType type;

    public enum vehicleType {
        MOTORCYCLE,
        CAR,
        VAN
    };

    public vehicleType getType() {
        return type;
    }

    public Vehicle(String licensePlate, vehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate=" + licensePlate +
                ", type=" + type +
                '}';
    }
}
