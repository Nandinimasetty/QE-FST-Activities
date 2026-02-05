package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestActivity9 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/alerts");
        Reporter.log("Browser opened and Alerts page launched", true);
    }
    @BeforeMethod
    public void switchBackToPage() {
        driver.switchTo().defaultContent();
    }
    @Test
    public void simpleAlertTestCase() {
        driver.findElement(By.xpath("//*[@id='simple']")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Simple Alert Text: " + alertText);
        alert.accept();
        String resultText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        System.out.println("Result Text: " + resultText);
        Reporter.log("Simple Alert handled", true);
        Assert.assertTrue(resultText.contains("simple"));
    }
    @Test
    public void confirmAlertTestCase() {
        driver.findElement(By.xpath("//*[@id='confirmation']")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Confirmation Alert Text: " + alertText);
        alert.accept();  
        String resultText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        System.out.println("Result Text: " + resultText);
        Reporter.log("Confirmation Alert handled", true);
        Assert.assertTrue(resultText.contains("accepted") || resultText.contains("confirmed"));
    }
    @Test
    public void promptAlertTestCase() {
        driver.findElement(By.xpath("//*[@id='prompt']")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Prompt Alert Text: " + alertText);
        alert.sendKeys("TestNG Alert");
        alert.accept();
        String resultText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        System.out.println("Result Text: " + resultText);
        Reporter.log("Prompt Alert handled", true);
        Assert.assertTrue(resultText.contains("TestNG Alert"));
    }
    @AfterClass
    public void tearDown() {
        driver.close();
        Reporter.log("Browser closed", true);
    }
}



