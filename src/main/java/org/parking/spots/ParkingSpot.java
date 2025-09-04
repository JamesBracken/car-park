package org.parking.spots;

import org.parking.vehicles.Vehicle;

public abstract class ParkingSpot {
    private boolean isEmpty = true;
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

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "isEmpty=" + isEmpty +
                ", vehicle=" + vehicle +
                '}';
    }
}
