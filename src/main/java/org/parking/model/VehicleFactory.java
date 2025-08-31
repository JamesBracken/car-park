package org.parking.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VehicleFactory {
    private final Random random = new Random();

    public Vehicle createRandomVehicle() {
        // IMPLEMENT A SWITCH INSTEAD TO GENERATE THE RANDOMLY SELECTED VEHICLE
        return new Vehicle(licensePlateGenerator(), randomVehicleSelector());
    }

    public Vehicle.vehicleType randomVehicleSelector() {
        List<Vehicle.vehicleType> vehicleTypes = Arrays.asList(Vehicle.vehicleType.values());
        return vehicleTypes.get(random.nextInt(3));
    }

    public StringBuilder licensePlateGenerator() {
        StringBuilder licensePlate = new StringBuilder();
        // ASCII ALPHABET DECIMALS  - 65-90
        for (int i = 0; i < 3; i++) {
            int randIntForAlphabet = random.nextInt(26);
            licensePlate.append((char) (randIntForAlphabet + 65));
        }
        // ASCII NUMBERS DECIMALS  - 48-57
        for (int i = 0; i < 3; i++) {
            int randIntForNums = random.nextInt(10);
            licensePlate.append((char) (randIntForNums + 48));
        }

        return licensePlate;
    }
}
