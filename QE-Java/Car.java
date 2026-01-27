package com.example;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;
    public Car(){
        tyres=4;
        doors=4;
    }
    public void displayCharacterstics(){
        System.out.println("Make: "+make);
        System.out.println("Color: "+color);
        System.out.println("Transmission:"+transmission);
        System.out.println("Tyres: "+tyres);
        System.out.println("Doors: "+doors);
    }
    public void accelerate(){
        System.out.println("Car is moving forward");

    }
    public void brake(){
        System.out.println("Car has stopped");
    }
    public static void main(String[] args){
       Car carName=new Car();
       carName.make=2015;
       carName.color="black";
       carName.transmission="Manual";
       carName.displayCharacterstics();
       carName.accelerate();
       carName.brake();
       
    }

}

    
  



