package com.example;

abstract class Boook {
    String title;
    abstract void setTitle(String s);
    
    String getTitle(){
            return title;
        }
    }
    
class MyBook extends Boook{
    void setTitle(String s){
        title=s;
    }
}
public class Book{
    public static void main(String[] args){
        Boook newNovel=new MyBook();
        newNovel.setTitle("Java Programming");
        System.out.println("The title is:"+newNovel.getTitle());
    }
}


