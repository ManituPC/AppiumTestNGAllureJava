package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextNoteScreen extends Screen {

    public TextNoteScreen(WebDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/edit_title")
    WebElement etNameNote;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/edit_note")
    WebElement etTextNote;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/color_btn")
    WebElement btnColor;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/btn1")
    WebElement btnColorRed;

    @Step("We fill title and description, then select color")
    public HomeScreen editNewTextNoteRed() throws InterruptedException {
        etNameNote.sendKeys("Test title");
        etTextNote.sendKeys("Test text");
        ((AndroidDriver<WebElement>) appiumDriver).hideKeyboard();
        btnColor.click();
        btnColorRed.click();
        ((AndroidDriver<WebElement>) appiumDriver).pressKeyCode(AndroidKeyCode.BACK);
        Thread.sleep(2000);
        ((AndroidDriver<WebElement>) appiumDriver).pressKeyCode(AndroidKeyCode.BACK);
        return PageFactory.initElements(appiumDriver, HomeScreen.class);
    }

}
