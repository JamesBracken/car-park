package org.parking;

import org.parking.model.*;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ParkingMain {
    public static void main(String[] args) {

        ParkingLot myParkingLot = new ParkingLot(5, 5, 6);

        VehicleFactory myFactory = new VehicleFactory();
        List<Vehicle> myGarage = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
//            myParkingLot.parkVehicle(myFactory.createRandomVehicle());
            myParkingLot.parkVehicle(myFactory.createVehicle(Vehicle.vehicleType.VAN));
            myParkingLot.parkVehicle(myFactory.createVehicle(Vehicle.vehicleType.CAR));
            myParkingLot.parkVehicle(myFactory.createVehicle(Vehicle.vehicleType.MOTORCYCLE));
        }

//        System.out.println("Vehicle.vehicleType.values().length: " + Vehicle.vehicleType.values().length);

//        System.out.println("showParkingSpaces: " + myParkingLot.showParkingSpaces());
//        System.out.println("isParkingLotEmpty: " + myParkingLot.isParkingLotEmpty());
        System.out.println("getSpaceVansUse: " + myParkingLot.getSpaceVansUse());
//        System.out.println("TESTING: " + myParkingLot.getLargeParking().stream().filter(largeSpot -> {
//            if(!largeSpot.isEmpty()) {
//                return largeSpot.getVehicle().getType() == Vehicle.vehicleType.VAN;
//            }
//            return false;
//        }).count());
//        System.out.println("TESTING: " + (int) getLargeParking().stream().filter(spot -> if(spot) spot.getVehicle().getType() == Vehicle.vehicleType.VAN).count());
        System.out.println("getParkedVehicles: " + myParkingLot.getParkedVehicles());
//        System.out.println("exitVehicle: " + myParkingLot.exitVehicle(myParkingLot.getMotorcycleParking().stream()
//                .filter(ParkingSpot::isEmpty).findFirst().get().getVehicle()));
//        System.out.println("exitVehicle: " + myParkingLot.exitVehicle(myParkingLot.getMotorcycleParking().get(0).getVehicle()));
//        System.out.println("exitVehicle: " + myParkingLot.getMotorcycleParking().stream()
//                .filter(ParkingSpot::isEmpty).findFirst().get().getVehicle());

        myParkingLot.parkVehicle(myFactory.createVehicle(Vehicle.vehicleType.MOTORCYCLE));

        Vehicle myVehicle = myFactory.createVehicle(Vehicle.vehicleType.MOTORCYCLE);

        myParkingLot.parkVehicle(myVehicle);

        System.out.println("Exit Vehicle: " + myVehicle);
        System.out.println(myParkingLot.getMotorcycleParking());
        myParkingLot.exitVehicle(myVehicle);
    }
}

//
//
//
//
//------------------------------------------------------------------------
// The parking lot can hold motorcycles, cars and vans
// The parking lot has motorcycle spots, car spots and large spots
// A motorcycle can park in any spot
// A car can park in a single compact spot, or a regular spot
// A van can park, but it will take up 3 regular spots
// These are just a few assumptions. Feel free to ask your interviewer about more assumptions as needed
