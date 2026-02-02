package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/dynamic-content");
        driver.manage().window().maximize();

        System.out.println("Page Title: " + driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//button[contains(text(),'Click me')]")).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='word']"),"release"));

        WebElement dynamicText = driver.findElement(By.xpath("//*[@id='word']"));
        System.out.println("Dynamic Text: " + dynamicText.getText());

        driver.quit();
    }
}

