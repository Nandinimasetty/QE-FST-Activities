package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4Test {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifySecondPopularCourseTitle() {

        driver.get("https://alchemy.hguy.co/lms");

        String actualTitle = driver.findElement(
                By.xpath("//*[@id=\"post-71\"]/div[2]/h3")
        ).getText();

        System.out.println("Second Most Popular Course Title: " + actualTitle);

        String expectedTitle = "Email Marketing Strategies";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


