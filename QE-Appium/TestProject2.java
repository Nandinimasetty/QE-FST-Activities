package demos;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestProject2 {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException, URISyntaxException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp("C:\\Users\\MasettyLakshmiNandin\\Desktop\\QE-Activities\\qe-appium\\src\\test\\resources\\ts-todo-list-v1.apk");

        options.setAppWaitActivity("*");
        options.setNoReset(true);
        options.setFullReset(false);
        options.setCapability("appium:forceAppLaunch", true);
        options.setCapability("appium:shouldTerminateApp", true);
        URL serverURL = new URI("http://127.0.0.1:4723").toURL();
        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void longPressElement(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("duration", 2000); // 2 seconds

        driver.executeScript("mobile: longClickGesture", params);
    }

    @Test
    public void editFirstTaskDeadlineTest() {

        By activity1 = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.app.todolist:id/tv_exlv_task_name' and @text='Activity 1']");
        longPressElement(activity1);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc='21 February 2026']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/bt_deadline_ok"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/bt_new_task_ok"))).click();
        WebElement deadline = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.app.todolist:id/tv_exlv_task_deadline'])[1]")));
        System.out.println("Deadline text: " + deadline.getText());
        Assert.assertTrue(deadline.isDisplayed(), "Deadline not set");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
