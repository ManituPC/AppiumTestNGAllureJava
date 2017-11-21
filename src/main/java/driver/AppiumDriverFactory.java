package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

import static com.google.common.base.Preconditions.checkNotNull;

public class AppiumDriverFactory {

    public static AppiumDriver<WebElement> appiumDriver;

    private AppiumDriverFactory() {
    }

    public static AppiumDriver<WebElement> getAppiumDriver() throws Exception {

        File appDir = new File(System.getProperty("user.dir"));
        File app = new File(appDir, "colornote.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "07d66c2500ca0342");
        capabilities.setCapability(MobileCapabilityType.APP, app);

        appiumDriver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4725/wd/hub"), capabilities);

        return appiumDriver;
    }

    public static WebDriver getInitDriver() {
        return checkNotNull(appiumDriver,
                "WebDriver not initialized - "
                        + "you are calling webDriver before or "
                        + "after browser was opened or closed");
    }

    public static void killDriverInstance() {
        appiumDriver.quit();
    }
}
