package com.example;

public class Activity3 {
    public static void main(String[] args){
    double seconds=1000000000.0;
    double earthYearSeconds=31557600.0;
    double earthAge=seconds/earthYearSeconds;
    double mercury=earthAge/0.2408467;
    double venus=earthAge/0.61519726;
    double mars=earthAge/1.8808158;
    double jupiter=earthAge/11.862615;
    double satrun=earthAge/29.447498;
    double uranus=earthAge/84.016846;
    double neptune=earthAge/164.79132;
    System.out.println("Age on Earth: "+jupiter);
    System.out.println("Age on Mercury: "+mercury);
    System.out.println("Age on Venus: "+venus);
    System.out.println("Age on Mars: "+mars);
    System.out.println("Age on Jupiter: "+jupiter);
    System.out.println("Age on Satrun: "+satrun);
    System.out.println("Age on Uranus: "+uranus);
    System.out.println("Age on Neptune: "+neptune);
    }
}
