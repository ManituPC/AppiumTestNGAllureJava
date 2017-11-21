package driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {

    AppiumDriver<WebElement> appiumDriver;

    public AppiumDriver<WebElement> getAppiumDriver() {
        return appiumDriver;
    }

    @BeforeMethod
    @Parameters({ "osType", "appType", "mobileDeviceName" })
    public void setUp() throws Exception {
        appiumDriver = AppiumDriverFactory.getAppiumDriver();
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        if(appiumDriver != null) {
            AppiumDriverFactory.killDriverInstance();
        }
    }
}
