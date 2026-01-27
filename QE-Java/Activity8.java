package com;
class CustomException extends Exception{
    private String message;
    public CustomException(String message){
        this.message=message;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
public class Activity8 {
    public static void exceptionTest(String s) throws CustomException{
        if(s==null){
            throw new CustomException("Custom exception string value is null");
        }else{
            System.out.println(s);
        }
    }
    public static void main(String[] args){
        try{
            exceptionTest(null);
        }
        catch(CustomException e){
            System.out.println(e.getMessage());
        }

    }
}


