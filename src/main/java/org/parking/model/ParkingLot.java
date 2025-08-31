package org.parking.model;

import java.util.*;

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
        } else if (isMotorcycle || isCar || isVan) {
            System.out.println("We dont currently have space for your vehicle");
        } else {
            System.out.println("Unfortunately our lovely parking does not support that strange vehicle: " + vehicle.getType() +  ", go somewhere else.");
        }
    }

    public String showParkingSpaces() {
        if (isParkingLotFull()) {
            return displayFullParking();
        }
        return String.format("Motorcycle spaces: %d \n" +
                "Car spaces: %d \n" +
                "Large vehicle spaces: %d \n" +
                "Total spaces: %d", showMotorcycleSpaces(), showCarSpaces(), showLargeSpaces(), showMotorcycleSpaces() + showCarSpaces() + showLargeSpaces());
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

    public boolean isParkingLotFull() {
        int totalSpaces = (int) (showMotorcycleSpaces() + showCarSpaces() + showLargeSpaces());
        System.out.println("isParkingLotFull totalSpaces result: " + totalSpaces);
        return totalSpaces == 0;
    }

    public String displayFullParking() throws RuntimeException {
        if (isParkingLotFull()) {
            return "The parking lot is currently filled to the brim, no parking spots are available";
        }
        throw new RuntimeException("The parking is not full but method displayFullParking is called");
    }

    public boolean isParkingLotEmpty() {
        return isMotorcycleParkingEmpty() && isCarParkingEmpty() && isLargeParkingEmpty();
    }

    public boolean isMotorcycleParkingEmpty() {
        return getMotorcycleParking().stream().noneMatch(Objects::nonNull);
    }

    public boolean isCarParkingEmpty() {
        return getMotorcycleParking().stream().noneMatch(Objects::nonNull);
    }

    public boolean isLargeParkingEmpty() {
        return getMotorcycleParking().stream().noneMatch(Objects::nonNull);
    }

    public int getSpaceVansUse() {
        return (int) getLargeParking().stream().filter(vehicle -> vehicle.getType() == Vehicle.vehicleType.VAN).count();
    }
}
