package demos;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestProject {
    private AndroidDriver driver;
    //private WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException, URISyntaxException{
    UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName("android");
    options.setAutomationName("UiAutomator2");
    options.setApp("C:\\Users\\MasettyLakshmiNandin\\Desktop\\QE-Activities\\qe-appium\\src\\test\\resources\\ts-todo-list-v1.apk");
    options.setAppWaitActivity(".view.MainActivity");
    options.setAppWaitForLaunch(true);
    options.setNoReset(true);
    options.setFullReset(false);
    options.setCapability("appium:forceAppLaunch", true);
    options.setCapability("appium:shouldTerminateApp", true);


    URL serverURL = new URI("http://127.0.0.1:4723").toURL();

    driver = new AndroidDriver(serverURL, options);
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


}

  @Test(priority = 1)
   public void addTasksTest() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //task1
    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/et_new_task_name"))).sendKeys("Activity 1");

    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/tv_new_task_priority"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='High']"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/bt_new_task_ok"))).click();

//task2
    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/et_new_task_name"))).sendKeys("Activity 2");

    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/tv_new_task_priority"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Medium']"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/bt_new_task_ok"))).click();

//task3
    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/et_new_task_name"))).sendKeys("Activity 3");

    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/tv_new_task_priority"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Low']"))).click();

    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/bt_new_task_ok"))).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/tv_exlv_task_name")));

    List<WebElement> tasks = driver.findElements(AppiumBy.id("com.app.todolist:id/tv_exlv_task_name"));

    System.out.println("Total tasks added: " + tasks.size());

    Assert.assertEquals(tasks.size(), 3,"Expected 3 tasks but found " + tasks.size());

}
@AfterClass
    public void tearDown(){
        driver.quit();
    }
}
