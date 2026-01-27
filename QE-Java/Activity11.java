package com;
import java.util.HashMap;
import java.util.Map;
public class Activity11 {
    public static void main(String[] args){
        Map<Integer,String>colurs=new HashMap<>();
        colurs.put(1,"Red");
        colurs.put(2,"Blue");
        colurs.put(3,"Green");
        colurs.put(4,"Yellow");
        colurs.put(5,"Black");
        System.out.println("Colours Map: ");
        System.out.println(colurs);
        colurs.remove(2);
        if(colurs.containsValue("Green")){
            System.out.println("Green color exisits in the map");
        }
        else{
            System.out.println("Green color doesn't exisist in the map");
        }
        System.out.println("Size of the map:"+colurs.size());
    }
    

}
