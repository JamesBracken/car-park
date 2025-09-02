package org.parking.model;

public class StandardSpot extends ParkingSpot{

    @Override
    public SpotType getSpotType() {
        return null;
    }

    @Override
    public boolean isPermittedVehicles(Vehicle.vehicleType type) {
        return type == Vehicle.vehicleType.CAR || type == Vehicle.vehicleType.MOTORCYCLE || type == Vehicle.vehicleType.VAN;
    }
}
