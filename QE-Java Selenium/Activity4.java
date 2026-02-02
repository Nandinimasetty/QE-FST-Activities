package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/target-practice");
        System.out.println(driver.getTitle());

        WebElement header3 = driver.findElement(By.xpath("//h3[@class='text-3xl font-bold text-orange-600']"));
        System.out.println(header3.getText());

        WebElement header5 = driver.findElement(By.xpath("//h5[@class='text-3xl font-bold text-purple-600']"));
        System.out.println(header5.getCssValue("color"));

        WebElement purpleButton = driver.findElement(By.xpath("//button[contains(text(),'Purple')]"));
        System.out.println(purpleButton.getAttribute("class"));

        WebElement slateButton = driver.findElement(By.xpath("//button[contains(text(),'Slate')]"));
        System.out.println(slateButton.getText());
        
        driver.quit();
    }
}
