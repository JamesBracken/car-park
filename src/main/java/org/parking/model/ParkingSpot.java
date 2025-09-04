package org.parking.model;

public abstract class ParkingSpot {
    private boolean isEmpty = true;
    private boolean isFilled = false;
    private Vehicle vehicle = null;

    public abstract SpotType getSpotType();
    public abstract boolean isPermittedVehicles(Vehicle.vehicleType type);

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void removeVehicle() {
        this.vehicle = null;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        this.isEmpty = empty;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "isEmpty=" + isEmpty +
                ", isFilled=" + isFilled +
                ", vehicle=" + vehicle +
                '}';
    }
}
