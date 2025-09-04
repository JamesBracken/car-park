package org.parking;

import org.parking.vehicles.Vehicle;
import org.parking.vehicles.VehicleFactory;

public class ParkingMain {
    public static void main(String[] args) {

        ParkingLot myParkingLot = new ParkingLot(5, 10, 10);

        VehicleFactory myFactory = new VehicleFactory();
        for (int i = 0; i < 1; i++) {
//            myParkingLot.parkVehicle(myFactory.createRandomVehicle()); -- This can be used to randomise the vehicle, understandably not best practice for factory
            myParkingLot.parkVehicle(myFactory.createVehicle(Vehicle.vehicleType.VAN));
            myParkingLot.parkVehicle(myFactory.createVehicle(Vehicle.vehicleType.CAR));
            myParkingLot.parkVehicle(myFactory.createVehicle(Vehicle.vehicleType.MOTORCYCLE));
        }

        System.out.println("getLargeParking: " + myParkingLot.getLargeParking());
        System.out.println("getParkedVehicles: " + myParkingLot.getParkedVehicles());

        Vehicle myVehicle = myFactory.createVehicle(Vehicle.vehicleType.VAN);

        myParkingLot.parkVehicle(myVehicle);

        System.out.println("Exit Vehicle: " + myVehicle);
        System.out.println("getParkedVehicles: " + myParkingLot.getParkedVehicles());
        System.out.println("getLargeParking: " + myParkingLot.getCarParking());

        myParkingLot.exitVehicle(myVehicle);
        System.out.println("getLargeParking: " + myParkingLot.getCarParking());
        System.out.println("getParkedVehicles: " + myParkingLot.getParkedVehicles());
    }
}