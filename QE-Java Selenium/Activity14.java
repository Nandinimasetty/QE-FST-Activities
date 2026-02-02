package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/tables");
        driver.manage().window().maximize();

        System.out.println("Page Title: " + driver.getTitle());

        List<WebElement> rows = driver.findElements(
                By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr")
        );
        System.out.println("Number of Rows: " + rows.size());

        List<WebElement> columns = driver.findElements(
                By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[1]/td")
        );
        System.out.println("Number of Columns: " + columns.size());

        WebElement beforeSortBook = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[5]/td[2]"));
        System.out.println("5th Row Book Name Before Sorting: " + beforeSortBook.getText());

        WebElement priceHeader = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/thead/tr/th[5]"));
        priceHeader.click();

        Thread.sleep(2000);

        System.out.println("Sorted Price Values:");

        List<WebElement> prices = driver.findElements(By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr/td[5]"));

        for (WebElement price : prices) {
            System.out.println(price.getText());
        }

        WebElement afterSortBook = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[5]/td[2]"));
        System.out.println("5th Row Book Name After Sorting: " + afterSortBook.getText());

        driver.quit();
    }
}
