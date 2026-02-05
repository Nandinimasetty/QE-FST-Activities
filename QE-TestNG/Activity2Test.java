package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2Test {

    WebDriver driver;
    
    @BeforeClass
    public void setUp() {
        // Selenium Manager handles driver automatically
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void verifyHeading() {
        driver.get("https://alchemy.hguy.co/lms");
        String actualHeading = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Heading Title: " + actualHeading);
        String expectedHeading = "Learn from Industry Experts";
        Assert.assertEquals(actualHeading, expectedHeading,"Heading text does not match");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

