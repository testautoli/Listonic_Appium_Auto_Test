package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewListCreatePage {

    public NewListCreatePage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/" +
            "android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText")
    private WebElement newListNameEditText;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View" +
            "/android.view.View/android.view.View[2]/android.widget.Button")
    private WebElement createListButton;


    public void clickOnCreateListButton(){
        createListButton.click();
    }

    public void provideNameOfNewList(String nameList){
        newListNameEditText.sendKeys(nameList);
    }
}
