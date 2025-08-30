package org.parking.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VehicleFactory {
    private final Random random = new Random();

     public Vehicle createRandomVehicle() {
         return new Vehicle(licensePlateGenerator(), randomVehicleSelector());
     }

    public Vehicle.vehicleType randomVehicleSelector() {
        List<Vehicle.vehicleType> vehicleTypes = Arrays.asList(Vehicle.vehicleType.values());
        return vehicleTypes.get(random.nextInt(3));
    }

    public StringBuilder licensePlateGenerator() {
        StringBuilder licensePlate = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int randIntForAlphabet = random.nextInt(26);
            licensePlate.append((char) (randIntForAlphabet + 65));
        }
        for (int i = 0; i < 3; i++) {
            int randIntForNums = random.nextInt(10);
            licensePlate.append((char) (randIntForNums + 48));
        }

        return licensePlate;
    }
}


// NUMBERS - 48-57
// ALPHABET - 65-90