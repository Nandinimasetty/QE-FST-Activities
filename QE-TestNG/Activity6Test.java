package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6Test {

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void loginToSite() {
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("//*[@id=\"menu-item-1507\"]/a")).click();
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        Assert.assertTrue(pageTitle.contains("My Account"));
        driver.findElement(By.xpath("//*[@id=\"uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91\"]/div[2]/div[2]/a")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        String loggedInTitle = driver.getTitle();
        System.out.println("After Login Title: " + loggedInTitle);
        Assert.assertTrue(loggedInTitle.contains("My Account"));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

