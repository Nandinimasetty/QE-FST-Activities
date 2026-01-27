package com.example;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Activity6 {
    static class Plane{
        private int maxPassegeners;
        private List<String>passengers;
        private Date lastTimeTookOff;
        private Date lastTimeLanded;
        public Plane(int maxPassegeners){
            this.maxPassegeners=maxPassegeners;
            this.passengers=new ArrayList<>();
        }
        public void onboard(String name){
            if(passengers.size()<maxPassegeners){
                passengers.add(name);
            }else{
                System.out.println("Plane is full!");
            }
        }
        public Date takeOff(){
            lastTimeTookOff=new Date();
            return lastTimeTookOff;
        }
        public Date land(){
            lastTimeLanded=new Date();
            return lastTimeLanded;
        }
        public List<String>getPassengers(){
            return passengers;
        }
        public Date getLastTimeLanded(){
            return lastTimeLanded;
        }
    }
    public static void main(String[] args){
        Plane plane=new Plane(10);
        plane.onboard("Alice");
        plane.onboard("Bob");
        plane.onboard("Charlie");
        System.out.println("Takeoff time: "+plane.takeOff());
        System.out.println("Passengers onboard:"+plane.getPassengers());
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Landing time:"+plane.land());

    }

}
