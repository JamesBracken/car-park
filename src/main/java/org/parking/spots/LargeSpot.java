package org.parking.spots;

import org.parking.vehicles.Vehicle;

public class LargeSpot extends ParkingSpot {

    @Override
    public SpotType getSpotType() {
        return SpotType.LARGE;
    }

    @Override
    public boolean isPermittedVehicles(Vehicle.vehicleType type) {
        return type == Vehicle.vehicleType.MOTORCYCLE || type == Vehicle.vehicleType.CAR || type == Vehicle.vehicleType.VAN;
    }
}
