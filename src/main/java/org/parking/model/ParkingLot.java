package org.parking.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpot.spotType> motorcycleParking;
    private List<ParkingSpot.spotType> carParking;
    private List<ParkingSpot.spotType> largeParking;

    public ParkingLot(int motorcycleSpotsQty, int carSpotsQty, int largeSpotsQty) {
        this.motorcycleParking = new ArrayList<ParkingSpot.spotType>(Collections.nCopies(motorcycleSpotsQty, null));
        this.carParking = new ArrayList<ParkingSpot.spotType>(Collections.nCopies(carSpotsQty, null));
        this.largeParking = new ArrayList<ParkingSpot.spotType>(Collections.nCopies(largeSpotsQty, null));
    }

    public List<ParkingSpot.spotType> getMotorcycleParking() {
        return motorcycleParking;
    }

    public void setMotorcycleParking(List<ParkingSpot.spotType> motorcycleParking) {
        this.motorcycleParking = motorcycleParking;
    }

    public List<ParkingSpot.spotType> getCarParking() {
        return carParking;
    }

    public void setCarParking(List<ParkingSpot.spotType> carParking) {
        this.carParking = carParking;
    }

    public List<ParkingSpot.spotType> getLargeParking() {
        return largeParking;
    }

    public void setLargeParking(List<ParkingSpot.spotType> largeParking) {
        this.largeParking = largeParking;
    }
}

;
//    public parkCar;
//    public parkVan;

//    public exitMotorcycle;
//    public exitCar;
//    public exitVan;