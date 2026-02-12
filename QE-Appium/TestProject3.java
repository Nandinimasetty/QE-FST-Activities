package demos;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestProject3 {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() throws Exception {

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

    @Test
    public void markTasksCompleteTest() {

        
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[2]"))).click();
        By activity3 = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.app.todolist:id/tv_exlv_task_name' and @text='Activity 3']");

        longPressElement(activity3);

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"android:id/content\"])[1]"))).click();
        WebElement progressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/sb_new_task_progress")));

        int startX = progressBar.getLocation().getX();
        int width = progressBar.getSize().getWidth();
        int yAxis = progressBar.getLocation().getY() + (progressBar.getSize().getHeight() / 2);
        int moveToX = startX + (width / 2);  // 50%
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence slide = new Sequence(finger, 1);

        slide.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, yAxis));
        slide.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        slide.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), moveToX, yAxis));
        slide.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(slide));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/bt_new_task_ok"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("More options"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//*[@text='Completed tasks']"))).click();
        int completedTasks = driver.findElements(AppiumBy.id("com.app.todolist:id/tv_exlv_task_name")).size();
        System.out.println("Completed tasks displayed: " + completedTasks);
        Assert.assertEquals(completedTasks, 2, "Expected only 2 completed tasks");
    }
    public void longPressElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        HashMap<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("duration", 2000);

        driver.executeScript("mobile: longClickGesture", params);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
