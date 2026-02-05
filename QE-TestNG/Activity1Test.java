package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1Test {

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
    }
    @Test
    public void verifyTitle() {
        driver.get("https://alchemy.hguy.co/lms");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Alchemy LMS – An LMS Application";
        System.out.println("Website Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

