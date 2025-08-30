package org.parking;

import org.parking.model.*;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ParkingMain {
    public static void main(String[] args) {

        ParkingLot myParkingLot = new ParkingLot(10, 10, 20);

//        System.out.println(myParkingLot.getCarParking());
//        System.out.println(myParkingLot.getMotorcycleParking());
//        System.out.println(myParkingLot.getLargeParking());
//        TESTING ------------------------------------

        VehicleFactory myFactory = new VehicleFactory();
        List<Vehicle> myGarage = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myParkingLot.parkVehicle(myFactory.createRandomVehicle());
        }


        System.out.println("myParkingLot: " + myParkingLot);
    }
}

// Create a class ParkingLot FINISHED
// Create a class ParkingSpot FINISHED
// Add motorcycle, car, large enums as spotType to parkingSpot FINISHED
// Add motorcycleParking, carParking and largeParking to ParkingLot FINISHED
// Create each field as a list to contain ParkingSpot to dictate if parking is taken FINISHED
// Create an abstract class of vehicle with relevant fields - licensePlate and vehicleType FINISHED
// Create all vehicle classes extending the vehicle class FINISHED
// Create a vehicle factory which will generate vehicles which we will later use to populate the parking FINISHED
//
// Create a method which tells us how many spots are remaining
// Create a method which tells us how many total spots are in the parking lot
// Create a method which tells us when the parking lot is full
// Create a method which tells us when the parking lot is empty
// Create a method which tells us when certain spots are full e.g. when all motorcycle spots are taken
// Create a method which tells us how many spots vans are taking up
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
