package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    public CreateAccountPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout[5]/" +
            "android.view.ViewGroup/android.widget.Button")
    private WebElement nextButton;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout[1]/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement createAccountTitle;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout[4]/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.AutoCompleteTextView")
    private WebElement inputForProvideEmail;

    public void clickOnNextButtonOnCreateAccountPage() {
        nextButton.click();
    }

    public boolean checkIfCreateAccountTitleIsVisiable(){
        return createAccountTitle.isDisplayed();
    }

    public void provideEmailIntoEmailInput(String email){
        inputForProvideEmail.sendKeys(email);
    }



}
