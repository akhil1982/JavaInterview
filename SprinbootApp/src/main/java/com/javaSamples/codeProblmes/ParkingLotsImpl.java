package com.javaSamples.codeProblmes;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotsImpl {
}

enum VehicleSize {
    Motorcycle,Compact, Large;
}

abstract class Vehicle {

   private List<ParkingSpot> spots = new ArrayList<>();
   private VehicleSize size;
   private int spotsNeeded;

   public void setSize(VehicleSize size) {
       this.size = size;
   }

    public VehicleSize getSize() {
        return size;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public void setSpotsNeeded(int spotsNeeded) {
        this.spotsNeeded = spotsNeeded;
    }

    public void setSpots(ParkingSpot spot) {
       spots.add(spot);
   }

   public abstract boolean canGoInSpot(ParkingSpot spot);
}

class Motorcycle extends Vehicle{

    public Motorcycle(){
        setSpotsNeeded(1);
        setSize(VehicleSize.Motorcycle);
    }
    @Override
    public boolean canGoInSpot(ParkingSpot spot) {
        if(spot.getSize().equals(this.getSize())){
            return true;
        }
            return false;
    }
}

class Car extends Vehicle{

    public Car(){
        setSpotsNeeded(1);
        setSize(VehicleSize.Compact);
    }
    @Override
    public boolean canGoInSpot(ParkingSpot spot) {
        return true;
    }
}

class Truck extends Vehicle{

    public Truck(){
        setSpotsNeeded(1);
        setSize(VehicleSize.Compact);
    }
    @Override
    public boolean canGoInSpot(ParkingSpot spot) {
        return true;
    }
}

class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize size;
    private int level;
    private int row;
    private int spotNumber;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleSize getSize() {
        return size;
    }

    public int getLevel() {
        return level;
    }

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    //Steps to park a vehicle and remove a vehicle.
    public boolean isAvailable (){
        if (vehicle == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canFitSize(Vehicle vehicle){
        if(size.equals(vehicle.getSize())){
            return  true;
        }
        return false;
    }

    public void parkVehicle (Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void removeVehicle(){
        vehicle = null;
    }
}