package com;
import java.util.ArrayList;
public class Activity9 {
    public static void main(String[] args){
        ArrayList<String>myList=new ArrayList<>();
        myList.add("Alice");
        myList.add("Bob");
        myList.add("Charlie");
        myList.add("David");
        myList.add("Eva");
        System.out.println("All names in the list:");
        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
        System.out.println("\n3rdname in the list:");
        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
        System.out.println("\nchecking if 'David' Exists: ");
        System.out.println(myList.contains("David"));
        System.out.println("\nNumber of names in the list");
        System.out.println(myList.size());
        myList.remove("Bob");
        System.out.println("\nList afterremoving a name");
        for(String name:myList){
            System.out.println(name);
        }
        System.out.println("\nSize of the list after removal:");
        System.out.println(myList.size());
    }

}
