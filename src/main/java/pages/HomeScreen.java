package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen extends Screen {

    @FindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    WebElement btnDeny;

    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    WebElement btnAllow;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/img_sidebar")
    WebElement btnMenu;

    @FindBy(how = How.ID, id = "com.socialnmobile.dictapps.notepad.color.note:id/logo_image")
    WebElement logo;

    @FindBy(how = How.XPATH, using = "//android.widget.ImageButton[contains(@resource-id,'main_btn1')]")
    WebElement btnAdd;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/main_btn2")
    WebElement btnSearch;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/main_btn3")
    WebElement btnOptions;

    @FindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/text_button_center")
    WebElement btnSort;

    //Dialog choose of note
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView")
    WebElement btnAddTextNote;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView")
    WebElement btnAddChecklist;

    @FindBy()
    WebElement note;


    //Text note

    public HomeScreen(WebDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("We create new text note")
    public TextNoteScreen addNoteTextRed() throws InterruptedException {
        btnAllow.click();
        btnAddTextNote.isDisplayed();
        if(logo.isDisplayed()) {
            System.out.println("Logo is there.");
        } else {
            System.out.println("No logo!");
        }
        btnAdd.click();
        btnAddTextNote.click();
        return PageFactory.initElements(appiumDriver, TextNoteScreen.class);
    }

    public void checkNote() {
        note.isDisplayed();
    }
}
