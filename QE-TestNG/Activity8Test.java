package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8Test {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void contactAdmin() {
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("//*[@id=\"menu-item-1506\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_0\"]")).sendKeys("Test User");
        driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_1\"]")).sendKeys("testuser@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_3\"]")).sendKeys("Automation Test");
        driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_2\"]")).sendKeys("This is a test message sent using Selenium TestNG.");
        driver.findElement(By.xpath("//*[@id=\"wpforms-submit-8\"]")).click();
        String confirmationMessage = driver.findElement(By.id("wpforms-confirmation-8")).getText();
        System.out.println("Confirmation Message: " + confirmationMessage);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
