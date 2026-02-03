package demos;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/tabs");

        System.out.println("Main Page Title: " + driver.getTitle());

        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent Handle: " + parentHandle);

        String openTabXpath = "//button[text()='Open A New Tab']";

        driver.findElement(By.xpath(openTabXpath)).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        System.out.println("First New Tab Title: " + driver.getTitle());
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/main/div/div/div/div/h2"))).getText();

        System.out.println("First New Tab Message: " + message);

        driver.quit();
    }
}
