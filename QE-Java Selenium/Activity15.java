package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity15 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/dynamic-attributes");
        driver.manage().window().maximize();

        System.out.println("Page Title: " + driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        
        String fullName = "Nandini Masetty";
        String email = "Nandini@gmail.com";
        String eventDate = "25/12/2026";
        String details = "Selenium Dynamic Attributes Testing";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'full-name')]"))).sendKeys(fullName);

        driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys(email);

        driver.findElement(By.xpath("//*[@id='signInForm']/input[3]")).sendKeys(eventDate);

        driver.findElement(By.xpath("//textarea[contains(@id,'additional-details')]")).sendKeys(details);

        driver.findElement(By.xpath("//*[@id='signInForm']/button")).click();

        String successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='action-confirmation']"))).getText();

        System.out.println("Your event has been scheduled! " + successMessage);

        driver.quit();
    }
}


