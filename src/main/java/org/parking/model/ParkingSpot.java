package org.parking.model;

public class ParkingSpot {
    private SpotType type;


    public ParkingSpot(SpotType type) {
        this.type = type;
    }

    public SpotType getType() {
        return type;
    }

    public void setType(SpotType type) {
        this.type = type;
    }
}
