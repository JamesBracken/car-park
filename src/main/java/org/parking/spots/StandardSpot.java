package org.parking.spots;

import org.parking.vehicles.Vehicle;

public class StandardSpot extends ParkingSpot {

    @Override
    public SpotType getSpotType() {
        return SpotType.STANDARD;
    }

    @Override
    public boolean isPermittedVehicles(Vehicle.vehicleType type) {
        return type == Vehicle.vehicleType.CAR || type == Vehicle.vehicleType.MOTORCYCLE || type == Vehicle.vehicleType.VAN;
    }
}
