package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity2 {

    WebDriver driver;
    
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://training-support.net/webelements/target-practice/");
    }
    public void testPageTitle() {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertEquals(title, "Selenium: Target Practice");
    }
    @Test
    public void testBlackButtonFail() {
        System.out.println("Finding Black Button");

        String blackButtonText =
                driver.findElement(By.id("black")).getText();

        Assert.assertEquals(blackButtonText, "Wrong Text");
    }
    @Test(enabled = false)
    public void testDisabled() {
        System.out.println("This test is disabled");
    }
    @Test
    public void testSkipped() {
        System.out.println("Skipping this test using SkipException");
        throw new SkipException("Skipping test intentionally");
    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
