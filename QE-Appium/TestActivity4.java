package demos;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestActivity4 {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException, URISyntaxException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setNoReset(true);
        options.setFullReset(false);

        options.setAppPackage("com.google.android.contacts");
        options.setAppActivity("com.android.contacts.activities.PeopleActivity");

        URL server = new URI("http://127.0.0.1:4723").toURL();
        driver = new AndroidDriver(server, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addNewContact() {

        WebElement contactsApp = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@content-desc='Predicted app: Contacts']")));
        contactsApp.click();

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.contacts:id/floating_action_button")));
        addButton.click();

        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text=\"First name\"]")));
        firstName.sendKeys("Aditya");

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Last name\"]")).sendKeys("Varma");

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='+1']")).sendKeys("9991482921");

        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button")).click();

        WebElement contactName = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.contacts:id/large_title\"]")));

        Assert.assertTrue(contactName.isDisplayed(), "Contact was not added");

        System.out.println("Contact Added Successfully");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
