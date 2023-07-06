package pages;

import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properities.EnvironmentConfig;

public class ChangeAddressEmailPage {

    public ChangeAddressEmailPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/" +
            "android.view.View/android.view.View[1]/android.widget.EditText[2]")
    private WebElement newEmailAddressTextView;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/" +
            "android.view.View/android.view.View[1]/android.widget.EditText[3]")
    private WebElement confirmAddressEmailTextLabel;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/" +
            "android.view.View/android.view.View/android.view.View[1]/android.widget.EditText[4]")
    private WebElement passwordTextLabel;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/" +
            "android.view.View/android.view.View/android.view.View[3]/android.widget.Button")
    private WebElement confirmChangeEmailButton;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/" +
            "android.view.View/android.view.View[3]")
    private WebElement emailChangedToast;


    public boolean checkIfToastEmailChangedIsDisplayed(){
        return emailChangedToast.isDisplayed();
    }

    public void clickOnConfirmChangeEmailButton(){
        confirmChangeEmailButton.click();
    }

    public void clickAndTapNewAddressEmail(){
        newEmailAddressTextView.click();
        newEmailAddressTextView.sendKeys(environmentConfig.getEmailToChange());
    }

    public void clickAndTapNewAddressEmailBack(){
        newEmailAddressTextView.click();
        newEmailAddressTextView.sendKeys(environmentConfig.getEmailForChange());
        confirmAddressEmailTextLabel.click();
        confirmAddressEmailTextLabel.sendKeys(environmentConfig.getEmailForChange());
    }


    public void clickAndTapNewConfirmEmail(){
        confirmAddressEmailTextLabel.click();
        confirmAddressEmailTextLabel.sendKeys(environmentConfig.getEmailToChange());
    }

    public void clickAndTapNewPassword(){
        passwordTextLabel.click();
        passwordTextLabel.sendKeys(environmentConfig.getPasswordForEmailChange());
    }
}
