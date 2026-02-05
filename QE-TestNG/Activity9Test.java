package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9Test {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void completeLesson() {
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("//*[@id=\"menu-item-1508\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"post-69\"]")).click();
        String courseTitle = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Course Title: " + courseTitle);
        Assert.assertEquals(courseTitle, "Social Media Marketing");
        driver.findElement(By.xpath("//*[@id=\"ld-expand-83\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"learndash_post_69\"]/div/div[1]/div[2]")).click();
        System.out.println("Lesson marked as complete");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


