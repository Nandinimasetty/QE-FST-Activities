package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {

    public static void main(String[] args) {

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

        System.out.println("Third Row Values:");

        List<WebElement> thirdRowCells = driver.findElements(
                By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[3]/td")
        );

        for (WebElement cell : thirdRowCells) {
            System.out.println(cell.getText());
        }

        WebElement cell_2_2 = driver.findElement(
                By.xpath("/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]")
        );
        System.out.println("2nd Row 2nd Column: " + cell_2_2.getText());

        driver.quit();
    }
}

