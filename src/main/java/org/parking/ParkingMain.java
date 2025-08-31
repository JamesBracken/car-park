package org.parking;

import org.parking.model.*;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ParkingMain {
    public static void main(String[] args) {

        ParkingLot myParkingLot = new ParkingLot(10, 10, 20);

        VehicleFactory myFactory = new VehicleFactory();
        List<Vehicle> myGarage = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myParkingLot.parkVehicle(myFactory.createRandomVehicle());
        }

        System.out.println("myParkingLot: " + myParkingLot);
        System.out.println("myParkingLot showMotorcycleSpaces: " + myParkingLot.showMotorcycleSpaces());
        System.out.println("myParkingLot showCarSpaces: " + myParkingLot.showCarSpaces());
        System.out.println("myParkingLot showLargeSpaces: " + myParkingLot.showLargeSpaces());
        System.out.println("myParkingLot showParkingSpaces \n" + myParkingLot.showParkingSpaces());
        System.out.println("myParkingLot isParkingLotFull \n" + myParkingLot.isParkingLotFull());
        System.out.println("myParkingLot isParkingLotEmpty \n" + myParkingLot.isParkingLotEmpty());
        System.out.println("myParkingLot isMotorcycleParkingEmpty \n" + myParkingLot.isMotorcycleParkingEmpty());
        System.out.println("myParkingLot isCarParkingEmpty \n" + myParkingLot.isCarParkingEmpty());
        System.out.println("myParkingLot isLargeParkingEmpty \n" + myParkingLot.isLargeParkingEmpty());

        System.out.println("myParkingLot showLargeSpaces: " + myParkingLot.showLargeSpaces());
        System.out.println("myParkingLot getSpaceVansUse \n" + myParkingLot.getSpaceVansUse());
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
