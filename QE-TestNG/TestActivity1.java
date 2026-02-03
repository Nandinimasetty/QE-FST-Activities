package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity1 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://training-support.net");
    }

    @Test
    public void verifyPageTitles() {

        String homeTitle = driver.getTitle();
        Reporter.log("Home Page Title: " + homeTitle, true);
        Assert.assertEquals(homeTitle, "Training Support");
        driver.findElement(By.linkText("About Us")).click();
        String aboutTitle = driver.getTitle();
        System.out.println("About us Page title:"+aboutTitle);
        Assert.assertEquals(aboutTitle, "About Training Support");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

