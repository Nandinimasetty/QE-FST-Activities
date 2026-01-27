package com;
import java.util.HashSet;
public class Activity10 {
    public static void main(String[] args){
        HashSet<String>hs=new HashSet<>();
        hs.add("Apple");
        hs.add("Mango");
        hs.add("Banana");
        hs.add("Orange");
        hs.add("Grapes");
        hs.add("pineapple");
        System.out.println("Size of hash set: "+hs.size());
        hs.remove("Mango");
        boolean removed=hs.remove("Cherry");
        System.out.println("Is 'Cherry' removed ? "+removed);
        System.out.println("Does HashSet contains 'Apple'? "+hs.contains("Apple"));
        System.out.println("Does HashSet contains 'Mango' ? "+hs.contains("Mango"));
        System.out.println("Updated HashSet: ");
        System.out.println(hs);
    }

}
