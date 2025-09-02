package org.parking.model;

public class CompactSpot extends ParkingSpot{

    @Override
    public SpotType getSpotType() {
        return null;
    }

    @Override
    public boolean isPermittedVehicles(Vehicle.vehicleType type) {
        return type == Vehicle.vehicleType.MOTORCYCLE;
    }
}
