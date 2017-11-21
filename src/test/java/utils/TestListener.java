package utils;

import driver.AppiumDriverFactory;
import driver.TestBase;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener {

    private static String getTesMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(AppiumDriver<WebElement> driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plane")
    public static String saveTextLog(String message){
        return message;
    }


    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTesMethodName(iTestResult) + " failed");

        //Get driver from TestBase and assign to local WebDriver variable.
        Object testClass = iTestResult.getInstance();
        AppiumDriver<WebElement> driver = ((TestBase) testClass).getAppiumDriver();

        //Allure Screenshot and SaveTestLog
        if (driver != null) {
            System.out.println("Screenshot captured for test case: " + getTesMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }

        //Save a log on Allure
        saveTextLog(getTesMethodName(iTestResult) + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
