package org.parking.model;

import java.util.*;

public class ParkingLot {
    private List<CompactSpot> motorcycleParking;
    private List<StandardSpot> carParking;
    private List<LargeSpot> largeParking;
    Map<Vehicle, Set<ParkingSpot>> parkedVehicles = new HashMap<>();

    public Map<Vehicle, Set<ParkingSpot>> getParkedVehicles() {
        return parkedVehicles;
    }

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
                        getParkedVehicles().put(vehicle, new HashSet<>(Set.of(compactSpot)));
                    });
                } else if (firstAvailableCarParking.isPresent()) {
                    firstAvailableCarParking.ifPresent(standardSpot -> {
                        standardSpot.addVehicle(vehicle);
                        firstAvailableCarParking.get().setEmpty(false);
                        getParkedVehicles().put(vehicle, new HashSet<>(Set.of(standardSpot)));
                    });
                } else if (firstAvailableLargeParking.isPresent()) {
                    firstAvailableLargeParking.ifPresent(largeSpot -> {
                        largeSpot.addVehicle(vehicle);
                        firstAvailableLargeParking.get().setEmpty(false);
                        getParkedVehicles().put(vehicle, new HashSet<>(Set.of(largeSpot)));
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
                        getParkedVehicles().put(vehicle, new HashSet<>(Set.of(standardSpot)));
                    });
                } else if (firstAvailableLargeParking.isPresent()) {
                    firstAvailableLargeParking.ifPresent(largeSpot -> {
                        largeSpot.addVehicle(vehicle);
                        firstAvailableLargeParking.get().setEmpty(false);
                        getParkedVehicles().put(vehicle, new HashSet<>(Set.of(largeSpot)));
                    });
                } else {
                    System.out.println("All our Standard and Large spaces are taken :(");
                }
            }
            case VAN -> {
                int STANDARD_SPACE_FOR_VAN = 3;
                long availableCarParkingsCount = getCarParking().stream()
                        .filter(ParkingSpot::isEmpty).count();
                System.out.println("availableCarParkingsCount: " + availableCarParkingsCount);
                if (firstAvailableLargeParking.isPresent()) {
                    firstAvailableLargeParking.ifPresent(largeSpot -> {
                        largeSpot.addVehicle(vehicle);
                        firstAvailableLargeParking.get().setEmpty(false);
                        getParkedVehicles().put(vehicle, new HashSet<>(Set.of(largeSpot)));
                    });
                } else if (availableCarParkingsCount >= STANDARD_SPACE_FOR_VAN) {
                    HashSet<ParkingSpot> standardSpotSet = new HashSet<>();

                    for (int i = 0; i <= 2; i++) {
                        Optional<StandardSpot> firstAvailableCarParkingInLoop = getCarParking().stream()
                                .filter(ParkingSpot::isEmpty).findFirst();
                        firstAvailableCarParkingInLoop.ifPresent(standardSpot -> {
                            standardSpot.addVehicle(vehicle);
                            standardSpotSet.add(standardSpot);
                            firstAvailableCarParkingInLoop.ifPresent(spot -> spot.addVehicle(vehicle));
                            firstAvailableCarParkingInLoop.get().setEmpty(false);
                        });
                        getParkedVehicles().put(vehicle, standardSpotSet);
                    }
                } else {
                    System.out.println("All our Large and Standard spaces are taken :(");
                }
            }
            default ->
                    System.out.println("Unfortunately our car park does not support this strange vehicle, go elsewhere!");
        }

//        System.out.println(getMotorcycleParking());
//        System.out.println(getCarParking());
//        System.out.println(getLargeParking());
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
        return getMotorcycleParking().stream().filter(ParkingSpot::isEmpty).count();
    }

    public Long showCarSpaces() {
        return getCarParking().stream().filter(ParkingSpot::isEmpty).count();
    }

    public Long showLargeSpaces() {
        return getLargeParking().stream().filter(ParkingSpot::isEmpty).count();
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
        return showLargeSpaces() == 0 && showMotorcycleSpaces() == 0 && showCarSpaces() == 0;
    }

    public int getSpaceVansUse() {
        return (int) getLargeParking().stream().filter(largeSpot -> {
            if (!largeSpot.isEmpty()) {
                return largeSpot.getVehicle().getType() == Vehicle.vehicleType.VAN;
            }
            return false;
        }).count();
    }

    public void exitVehicle(Vehicle vehicle) {
        Optional<CompactSpot> getVehicleCompactSpot = getMotorcycleParking().stream().filter(compactSpot -> compactSpot.getVehicle() == vehicle).findFirst();
        Optional<StandardSpot> getVehicleStandardSpot = getCarParking().stream().filter(standardSpot -> standardSpot.getVehicle() == vehicle).findFirst();
        Optional<LargeSpot> getVehicleLargeSpot = getLargeParking().stream().filter(largeSpot -> largeSpot.getVehicle() == vehicle).findFirst();

        System.out.println("getVehicleCompactSpot: " + getVehicleCompactSpot);
        System.out.println("getVehicleStandardSpot: " + getVehicleStandardSpot);
        System.out.println("getVehicleLargeSpot: " + getVehicleLargeSpot);

        if (!getVehicleCompactSpot.equals(Optional.empty())) {

            getVehicleCompactSpot.get().setEmpty(true);
            getVehicleCompactSpot.get().removeVehicle();
            getParkedVehicles().remove(vehicle);

        } else if (!getVehicleStandardSpot.equals(Optional.empty())) {
            // Account for vans taking 3 standard spaces

            if (vehicle.getType().equals(Vehicle.vehicleType.VAN)) {
                for (int i = 0; i < 3; i++) {
                    Optional<StandardSpot> getVehicleStandardSpotInLoop = getCarParking().stream().filter(standardSpot -> standardSpot.getVehicle() == vehicle).findFirst();
                    getVehicleStandardSpotInLoop.get().setEmpty(true);
                    getVehicleStandardSpotInLoop.get().removeVehicle();
                }
                getParkedVehicles().remove(vehicle);
                return;
            }

            getVehicleStandardSpot.get().setEmpty(true);
            getVehicleStandardSpot.get().removeVehicle();
            getParkedVehicles().remove(vehicle);

        } else if (!getVehicleLargeSpot.equals(Optional.empty())) {
            getVehicleLargeSpot.get().setEmpty(true);
            getVehicleLargeSpot.get().removeVehicle();
            getParkedVehicles().remove(vehicle);

        }

        System.out.println("getVehicleCompactSpot: " + getVehicleCompactSpot);
        System.out.println("getVehicleStandardSpot: " + getVehicleStandardSpot);
        System.out.println("getVehicleLargeSpot: " + getVehicleLargeSpot);
    }
}
