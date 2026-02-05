package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3Test {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void verifyFirstInfoBoxTitle() {
        driver.get("https://alchemy.hguy.co/lms");
        String actualTitle = driver.findElement(By.xpath("//*[@id=\"uagb-infobox-f08ebab0-fbf1-40ec-9b2a-c9feeb3d4810\"]/div/div/div/div[2]/h3")).getText();
        System.out.println("First Info Box Title: " + actualTitle);
        String expectedTitle = "Actionable Training";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

