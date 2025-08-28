package org.parking.model;

public class ParkingSpot {
    private spotType type;


    public ParkingSpot(spotType type) {
        this.type = type;
    }

    public spotType getType() {
        return type;
    }

    public void setType(spotType type) {
        this.type = type;
    }

    public enum spotType {
        MOTORCYCLE,
        CAR,
        LARGE
    }
}


// Create a class ParkingSpot
// Add motorcycle, car, large enums as spotType to parkingSpot