package com;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.apache.commons.io.FileUtils;
import java.nio.charset.StandardCharsets;
public class Activity14 {
    public static void main(String[] args){
        try{
            File file=new File("sample.txt");
            boolean status=file.createNewFile();
            if(status){
                System.out.println("File created sucessfully");
            }else{
                System.out.println("File already exisits");
            }
            FileWriter writer=new FileWriter(file);
            writer.write("Welcome to activity 14\n");
            writer.write("File I/O operations in java");
            writer.close();
            String Data=Files.readString(file.toPath(),StandardCharsets.UTF_8);
            System.out.println("\nFile content:");
            System.out.println(Data);
            File destDir=new File("destDir");
            if(!destDir.exists()){
                destDir.mkdir();
            }
            FileUtils.copyFileToDirectory(file,destDir);
            System.out.println("\nFile copied to destination directory successfully");
        }
            catch(IOException e){
                e.printStackTrace();
            }
    }
}

        
    


