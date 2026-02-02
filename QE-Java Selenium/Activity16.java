package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity16 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/selects");
        driver.manage().window().maximize();

        System.out.println("Page Title: " + driver.getTitle());

        WebElement multiSelectElement = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/section//select"));

        Select multiSelect = new Select(multiSelectElement);

        List<WebElement> options = multiSelect.getOptions();

        List<WebElement> realOptions = options.subList(1, options.size());

        System.out.println("Total number of options: " + realOptions.size());

        multiSelect.selectByIndex(2);
        multiSelect.selectByIndex(3);
        multiSelect.selectByIndex(4);

        System.out.println("Total options in Single Select:");
        for (WebElement option : realOptions) {
            System.out.println(option.getText());
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
