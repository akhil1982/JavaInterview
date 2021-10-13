package com.javaSamples.designPatterns;

public class BuilderDemo {

    public static void main(String[] args){
        Igloobuilder builder = new Igloobuilder();
        CivilEngineer engineer = new CivilEngineer(builder);
        engineer.createHouse();
        House house = engineer.getHouse();
        System.out.println(house);
    }

}

/**
 * Defining the parts
 */
interface MainPlan {
    public void setFloor(String floor);
    public void setRoof(String roof);
    public void setWalls(String walls);
    public void setBasement(String basement);
}

class House implements MainPlan {

    private String roof;
    private String basement;
    private String floor;
    private String walls;

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setBasement(String basement) {
        this.basement = basement;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }
}

//Define the Algorithm
interface HouseBuilder{
    public void buildFloors();
    public void buildRoof();
    public void buildWalls();
    public void buildBasement();
    public House getHouse();
}

class Igloobuilder implements HouseBuilder{

    private House house;

    public Igloobuilder(){
        this.house=new House();
    }


    @Override
    public void buildFloors() {
        house.setBasement("Set ice basement");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Set ice roof");
    }

    @Override
    public void buildWalls() {
        house.setWalls("Set ice walls");
    }

    @Override
    public void buildBasement() {
            house.setBasement("Set ice basement");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}

class MudHousebuilder implements HouseBuilder{

    private House house;

    public MudHousebuilder(House house){
        this.house=house;
    }


    @Override
    public void buildFloors() {
        house.setBasement("Set mud basement");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Set mud roof");
    }

    @Override
    public void buildWalls() {
        house.setWalls("Set mud walls");
    }

    @Override
    public void buildBasement() {
        house.setBasement("Set mud basement");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}

class CivilEngineer {
    private HouseBuilder builder;

    public CivilEngineer(HouseBuilder builder) {
        this.builder=builder;
    }

    public void createHouse(){
        this.builder.buildBasement();
        this.builder.buildFloors();
        this.builder.buildRoof();
        this.builder.buildWalls();
    }

    public House getHouse(){
        return this.builder.getHouse();
    }
}


