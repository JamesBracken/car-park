package org.parking.spots;

import org.parking.vehicles.Vehicle;

public class CompactSpot extends ParkingSpot {

    @Override
    public SpotType getSpotType() {
        return SpotType.COMPACT;
    }

    @Override
    public boolean isPermittedVehicles(Vehicle.vehicleType type) {
        return type == Vehicle.vehicleType.MOTORCYCLE;
    }
}
