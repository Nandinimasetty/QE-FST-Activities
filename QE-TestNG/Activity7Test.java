package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7Test {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void countCourses() {
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("//*[@id=\"menu-item-1508\"]/a")).click();
        List<WebElement> courses =driver.findElements(By.className("ld_course_grid"));
        int courseCount = courses.size();
        System.out.println("Total number of courses: " + courseCount);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

