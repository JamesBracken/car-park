package org.parking.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {
    private List<Vehicle> motorcycleParking;
    private List<Vehicle> carParking;
    private List<Vehicle> largeParking;

    public ParkingLot(int motorcycleSpotsQty, int carSpotsQty, int largeSpotsQty) {
        this.motorcycleParking = new ArrayList<Vehicle>(Collections.nCopies(motorcycleSpotsQty, null));
        this.carParking = new ArrayList<Vehicle>(Collections.nCopies(carSpotsQty, null));
        this.largeParking = new ArrayList<Vehicle>(Collections.nCopies(largeSpotsQty, null));
    }

    public List<Vehicle> getMotorcycleParking() {
        return motorcycleParking;
    }

    public List<Vehicle> getCarParking() {
        return carParking;
    }

    public List<Vehicle> getLargeParking() {
        return largeParking;
    }

    public void setMotorcycleParking(List<Vehicle> motorcycleParking) {
        this.motorcycleParking = motorcycleParking;
    }

    public void setCarParking(List<Vehicle> carParking) {
        this.carParking = carParking;
    }

    public void setLargeParking(List<Vehicle> largeParking) {
        this.largeParking = largeParking;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "motorcycleParking=" + motorcycleParking + "\n" +
                ", carParking=" + carParking + "\n" +
                ", largeParking=" + largeParking +
                '}';
    }

    public void parkVehicle(Vehicle vehicle) {
        int firstAvailableMotorcycleParking = getMotorcycleParking().indexOf(null);
        int firstAvailableCarParking = getCarParking().indexOf(null);
        int firstAvailableLargeParking = getLargeParking().indexOf(null);

        boolean isMotorcycle = vehicle.getType().equals(Vehicle.vehicleType.MOTORCYCLE);
        boolean isCar = vehicle.getType().equals(Vehicle.vehicleType.CAR);
        boolean isVan = vehicle.getType().equals(Vehicle.vehicleType.VAN);

        if (firstAvailableMotorcycleParking >= 0 && isMotorcycle) {
            getMotorcycleParking().set(firstAvailableMotorcycleParking, vehicle);
        } else if (firstAvailableCarParking >= 0 && (isMotorcycle || isCar)) {
            getCarParking().set(firstAvailableCarParking, vehicle);
        } else if (firstAvailableLargeParking >= 0 && (isMotorcycle || isCar || isVan)) {
            if (isVan && (firstAvailableLargeParking + 3) < getLargeParking().size()) {
                for (int i = 0; i < 3; i++) {
                    int firstAvailableLargeParkingInner = getLargeParking().indexOf(null);
                    getLargeParking().set(firstAvailableLargeParkingInner, vehicle);
                }
            } else if (isMotorcycle || isCar) {
                getLargeParking().set(firstAvailableLargeParking, vehicle);
            } else {
                System.out.println("Your van is too big, there is no more space. Get out of here!");
            }
        } else if (firstAvailableLargeParking < 0 && (isMotorcycle || isCar || isVan)) {
            System.out.println("Unfortunately the parking is currently full");
        } else {
            System.out.println("Unfortunately our lovely parking does not support that strange vehicle, go somewhere else.");
        }
    }

    public String showParkingSpaces() {
        return String.format("Motorcycle spaces: %d \n" +
                "Car spaces: %d \n" +
                "Large vehicle spaces: %d \n" +
                "Total spaces: %d", showMotorcycleSpaces(),  showCarSpaces(), showLargeSpaces(), showMotorcycleSpaces() + showCarSpaces() + showLargeSpaces());
    }
    public Long showMotorcycleSpaces() {
        return getMotorcycleParking().stream().filter(Objects::isNull).count();
    }

    public Long showCarSpaces() {
        return getCarParking().stream().filter(Objects::isNull).count();
    }

    public Long showLargeSpaces() {
        return getLargeParking().stream().filter(Objects::isNull).count();
    }
}

;
//    public parkCar;
//    public parkVan;

//    public exitMotorcycle;
//    public exitCar;
//    public exitVan;