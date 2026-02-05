package stepdefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Activity3steps {

    static WebDriver driver;
    static WebDriverWait wait;
    static Alert alert;

    @Given("User is on the alerts page")
    public void user_is_on_the_alerts_page() {
        if (driver == null) {                    // ✅ PREVENTS MULTIPLE BROWSERS
            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        driver.get("https://training-support.net/webelements/alerts");
    }
    @When("User clicks the Simple Alert button")
    public void click_simple_alert() {
        driver.findElement(By.id("simple")).click();
    }
    @When("User clicks the Confirm Alert button")
    public void click_confirm_alert() {
        driver.findElement(By.id("confirmation")).click();
    }
    @When("User clicks the Prompt Alert button")
    public void click_prompt_alert() {
        driver.findElement(By.id("prompt")).click();
    }

    @Then("Alert opens")
    public void alert_opens() {
        alert = wait.until(ExpectedConditions.alertIsPresent());
    }

    @And("Read the text from it and print it")
    public void read_alert_text() {
        System.out.println("Alert Text: " + alert.getText());
    }

    @And("Write a custom message {string} in it")
    public void write_custom_message(String msg) {
        alert.sendKeys(msg);
    }

    @And("Close the alert")
    public void close_alert() {
        alert.accept();
    }

    @And("Close the alert with Cancel")
    public void close_alert_cancel() {
        alert.dismiss();
    }

    @And("Read the result text")
    public void read_result_text() {
        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id='result']")
                )
        );
        System.out.println("Result Text: " + result.getText());

        driver.quit();
        driver = null;
    }
}