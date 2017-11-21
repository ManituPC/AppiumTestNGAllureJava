package pages;

import org.openqa.selenium.WebDriver;

public abstract class Screen {

    protected WebDriver appiumDriver;

    public Screen(WebDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public WebDriver getWebDriver() {
        return appiumDriver;
    }
}
