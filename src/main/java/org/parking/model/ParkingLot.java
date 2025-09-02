package org.parking.model;

import java.util.*;

public class ParkingLot {
    private List<CompactSpot> motorcycleParking;
    private List<StandardSpot> carParking;
    private List<LargeSpot> largeParking;

    public ParkingLot(int compactSpotsQty, int standardSpotsQty, int largeSpotsQty) {
        this.motorcycleParking = new ArrayList<>();
        this.carParking = new ArrayList<>();
        this.largeParking = new ArrayList<>();
        generateParkingLotSpots(compactSpotsQty, standardSpotsQty, largeSpotsQty);
    }

    public void generateParkingLotSpots(int compactSpotsQty, int standardSpotsQty, int largeSpotsQty) {
        motorcycleSpotGenerator(compactSpotsQty);
        carSpotGenerator(standardSpotsQty);
        largeSpotGenerator(largeSpotsQty);
    }

    public void motorcycleSpotGenerator(int quantity) {
        for (int i = 0; i < quantity; i++) {
            motorcycleParking.add(new CompactSpot());
        }
    }

    public void carSpotGenerator(int quantity) {
        for (int i = 0; i < quantity; i++) {
            carParking.add(new StandardSpot());
        }
    }

    public void largeSpotGenerator(int quantity) {
        for (int i = 0; i < quantity; i++) {
            largeParking.add(new LargeSpot());
        }
    }

    public List<CompactSpot> getMotorcycleParking() {
        return motorcycleParking;
    }

    public void setMotorcycleParking(List<CompactSpot> motorcycleParking) {
        this.motorcycleParking = motorcycleParking;
    }

    public List<StandardSpot> getCarParking() {
        return carParking;
    }

    public void setCarParking(List<StandardSpot> carParking) {
        this.carParking = carParking;
    }

    public List<LargeSpot> getLargeParking() {
        return largeParking;
    }

    public void setLargeParking(List<LargeSpot> largeParking) {
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

    public void parkVehicle(Vehicle vehicle) throws NoSuchElementException {
//        int firstAvailableMotorcycleParking = getMotorcycleParking().indexOf(null);
//        MotorcycleSpot firstAvailableMotorcycleParking = getMotorcycleParking().stream().filter(ParkingSpot::isEmpty).findFirst().get();
//        CarSpot firstAvailableCarParking = getCarParking().stream().filter(ParkingSpot::isEmpty).findFirst().get();
//        LargeSpot firstAvailableLargeParking = getLargeParking().stream().filter(ParkingSpot::isEmpty).findFirst().get();


        Optional<CompactSpot> firstAvailableMotorcycleParking = getMotorcycleParking().stream()
                .filter(ParkingSpot::isEmpty).findFirst();
        Optional<StandardSpot> firstAvailableCarParking = getCarParking().stream()
                .filter(ParkingSpot::isEmpty).findFirst();
        Optional<LargeSpot> firstAvailableLargeParking = getLargeParking().stream()
                .filter(ParkingSpot::isEmpty).findFirst();


        boolean isMotorcycle = vehicle.getType().equals(Vehicle.vehicleType.MOTORCYCLE);
        boolean isCar = vehicle.getType().equals(Vehicle.vehicleType.CAR);
        boolean isVan = vehicle.getType().equals(Vehicle.vehicleType.VAN);

        switch (vehicle.getType()) {
            case MOTORCYCLE -> {
                if (firstAvailableMotorcycleParking.isPresent()) {
                    firstAvailableMotorcycleParking.ifPresent(compactSpot -> {
                        compactSpot.addVehicle(vehicle);
                        firstAvailableMotorcycleParking.get().setEmpty(false);
                    });
                } else if (firstAvailableCarParking.isPresent()) {
                    firstAvailableCarParking.ifPresent(standardSpot -> {
                        standardSpot.addVehicle(vehicle);
                        firstAvailableCarParking.get().setEmpty(false);
                    });
                } else if (firstAvailableLargeParking.isPresent()) {
                    firstAvailableLargeParking.ifPresent(largeSpot -> {
                        largeSpot.addVehicle(vehicle);
                        firstAvailableLargeParking.get().setEmpty(false);
                    });
                } else {
                    System.out.println("All our parking spots are full :(");
                }
            }
            case CAR -> {
                if (firstAvailableCarParking.isPresent()) {
                    firstAvailableCarParking.ifPresent(standardSpot -> {
                        standardSpot.addVehicle(vehicle);
                        firstAvailableCarParking.get().setEmpty(false);
                    });
                } else if (firstAvailableLargeParking.isPresent()) {
                    firstAvailableLargeParking.ifPresent(largeSpot -> {
                        largeSpot.addVehicle(vehicle);
                        firstAvailableLargeParking.get().setEmpty(false);
                    });
                } else {
                    System.out.println("All our Standard and Large spaces are taken :(");
                }
            }
            case VAN -> {
                if (firstAvailableLargeParking.isPresent()) {
                    firstAvailableLargeParking.ifPresent(largeSpot -> {
                        largeSpot.addVehicle(vehicle);
                        firstAvailableLargeParking.get().setEmpty(false);
                    });
                } else if (firstAvailableCarParking.isPresent()) {
                    firstAvailableCarParking.ifPresent(standardSpot -> {
                        standardSpot.addVehicle(vehicle);
                        firstAvailableCarParking.get().setEmpty(false);
                    });
                } else {
                    System.out.println("All our Large and Standard spaces are taken :(");
                }
            }
            default -> System.out.println("Unfortunately our car park does not support this strange vehicle, go elsewhere!");
        }
        System.out.println(vehicle.getType());
        System.out.println("getMotorcycleParking: " + getMotorcycleParking());
        System.out.println("getCarParking: " + getCarParking());
        System.out.println("getLargeParking: " + getLargeParking());
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

//    public int getSpaceVansUse() {
//        return (int) getLargeParking().stream().filter(vehicle -> vehicle.getType() == Vehicle.vehicleType.VAN).count();
//    }

}
