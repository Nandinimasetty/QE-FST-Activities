package com;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Activity13 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        List<Integer>list=new ArrayList<>();
        Random indexGen=new Random();
        System.out.println("Enter integer values(enter a non-integer to stop):");
        while(scan.hasNextInt()){
            list.add(scan.nextInt());
        }
        Integer[] nums=list.toArray(new Integer[0]);
        if(nums.length>0){
            int index=indexGen.nextInt(nums.length);
            System.out.println("Generated Index: "+index);
            System.out.println("Value at Index: "+nums[index]);
        }else{
            System.out.println("No integers were entered.");
        }
        
    }

}
