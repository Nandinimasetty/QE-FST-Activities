package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5Test {

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void navigateToMyAccountPage() {
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("//*[@id=\"menu-item-1507\"]/a")).click();
        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);
        Assert.assertTrue(actualTitle.contains("My Account"));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
