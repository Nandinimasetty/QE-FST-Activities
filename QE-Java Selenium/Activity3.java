package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String args[]){
        
        WebDriver driver = new FirefoxDriver();
        
        driver.get("https://training-support.net/webelements/login-form/");
        
        System.out.println(driver.getTitle());
        
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        
        driver.quit();
    }
}

       
    

