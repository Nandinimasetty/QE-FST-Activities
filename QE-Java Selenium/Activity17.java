package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/selects");
        driver.manage().window().maximize();

        System.out.println("Page Title: " + driver.getTitle());

        Select multiSelect = new Select(driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/section/div[2]/select")));

        driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/section/div[2]/select/option[2]")).click();

        multiSelect.selectByIndex(3);
        multiSelect.selectByIndex(4);
        multiSelect.selectByIndex(5);

        driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/section/div[2]/select/option[11]")).click();

        multiSelect.deselectByIndex(4);

        Thread.sleep(2000);
        driver.quit();
    }
}
