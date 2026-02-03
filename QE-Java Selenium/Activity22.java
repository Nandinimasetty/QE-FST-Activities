package demos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/popups");

        System.out.println("Page Title: " + driver.getTitle());

        driver.findElement(By.xpath("//*[@id='launcher']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));

        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin");

        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("password");

        System.out.println("Entered username and password");

        driver.findElement(By.xpath("//*[@id='signInForm']/button")).click();

        String confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/main/div/div/div/div/div/h2"))).getText();

        System.out.println("Confirmation Message: " + confirmationMessage);

        driver.quit();
    }
}
