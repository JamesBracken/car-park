package org.parking.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VehicleFactory {


    public Vehicle.vehicleType randomVehicleSelector() {
        List<Vehicle.vehicleType> vehicleTypes = Arrays.asList(Vehicle.vehicleType.values());

    }

    public StringBuilder licensePlateGenerator() {
        Random random = new Random();
        StringBuilder licensePlate = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int randIntForAlphabet = random.nextInt(27);
            licensePlate.append((char) (randIntForAlphabet + 65));
        }
        for (int i = 0; i < 3; i++) {
            int randIntForNums = random.nextInt(11);
            licensePlate.append((char) (randIntForNums + 48));
        }
        return licensePlate;
    }

}


// NUMBERS - 48-57
// ALPHABET - 65-90