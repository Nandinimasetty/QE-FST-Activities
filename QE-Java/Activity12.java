package com;
interface Addable{
    int add(int num1,int num2);
}
public class Activity12 {
    public static void main(String[] args){
    int num1=10;
    int num2=20;
    Addable od1=(a,b)->a+b;
    int result1=od1.add(num1,num2);
    Addable od2=(a,b)->{
        return a+b;
    };
    int result2=od2.add(num1,num2);
    System.out.println("Result from od1: "+result1);
    System.out.println("Result from od2: "+result2);
}

}
