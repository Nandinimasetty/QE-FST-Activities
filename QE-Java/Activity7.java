package com.example;
interface BicycleOperations{
    void applyBrake(int decrement);
    void speedUp(int increment);
}
class Bicycle implements BicycleOperations{
    protected int gears;
    protected int currentSpeed;
    protected int maxSpeed;
    Bicycle(int gears, int maxSpeed){
        this.gears=gears;
        this.maxSpeed=maxSpeed;
        this.currentSpeed=0;
    }
    public void applyBrake(int decrement){
        currentSpeed-=decrement;
        if(currentSpeed<0){
            currentSpeed=0;
        }
    }
    public void speedUp(int increment){
        currentSpeed+=increment;
        if(currentSpeed>maxSpeed){
            currentSpeed=maxSpeed;
        }
    }
    public String bicycleDesc(){
        return "No of gears are "+gears+", Max speed of bicycle is "+maxSpeed+", Current speed is "+currentSpeed;
    }
}
class MountainBike extends Bicycle{
    private int seatHeight;
    MountainBike(int gears, int maxSpeed,int seatHeight){
        super(gears, maxSpeed);
        this.seatHeight=seatHeight;
    }
    public void setSeatheight(int newValue){
        seatHeight=newValue;
    }
    public String bicycleDesc(){
        return super.bicycleDesc()+", Seat height is"+seatHeight;
    }
}
public class Activity7 {
    public static void main(String[] args){
        MountainBike mb=new MountainBike(5,25,10);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(10);
        System.out.println("After Speeding up: ");
        System.out.println(mb.bicycleDesc());
        mb.applyBrake(5);
        System.out.println("After applying brake:");
        System.out.println(mb.bicycleDesc());
        mb.setSeatheight(15);
        System.out.println("After changing seat height:");
        System.out.println(mb.bicycleDesc());
    }
}
