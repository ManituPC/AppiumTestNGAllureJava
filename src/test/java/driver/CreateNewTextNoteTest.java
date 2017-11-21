package driver;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomeScreen;
import utils.TestListener;

@Listeners({TestListener.class})
@Feature("Create new note")

public class CreateNewTextNoteTest extends TestBase {

    @Test
    @Description("On this test we will check function of add new note")
    public void createNewTextNote() throws InterruptedException {
        HomeScreen homeScreen = PageFactory.initElements(appiumDriver, HomeScreen.class);
        homeScreen.addNoteTextRed().editNewTextNoteRed();
    }


}
