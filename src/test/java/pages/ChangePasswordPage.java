package pages;

import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properities.EnvironmentConfig;

public class ChangePasswordPage {

    public ChangePasswordPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/" +
            "android.view.View/android.view.View[1]/android.widget.EditText[1]")
    private WebElement currentPasswordEditText;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/" +
            "android.view.View/android.view.View[1]/android.widget.EditText[2]")
    private WebElement newPasswordEditText;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/" +
            "android.view.View/android.view.View[1]/android.widget.EditText[3]")
    private WebElement confirmNewPasswordEditText;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/" +
            "android.view.View/android.view.View[3]/android.widget.Button")
    private WebElement confirmButton;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.view.View/android.view.View")
    private WebElement popUpAfterChangedPassword;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")
    private WebElement loginBtnOnPopUpAfterChangedPassword;


    public void clickConfirmButtonToChangePassword(){
        confirmButton.click();
    }

    public void clickAndTapCurrentPassword(){
        currentPasswordEditText.click();
        currentPasswordEditText.sendKeys(environmentConfig.getPasswordForEmailChange());
    }

    public void clickAndTapNewPassword(){
        newPasswordEditText.click();
        newPasswordEditText.sendKeys(environmentConfig.getPasswordToChange());
    }

    public void clickAndTapConfirmNewPassword(){
        confirmNewPasswordEditText.click();
        confirmNewPasswordEditText.sendKeys(environmentConfig.getPasswordToChange());
    }

    public boolean checkIfPopUpAfterChangedPasswordIsDisplayed(){
        return popUpAfterChangedPassword.isDisplayed();
    }

    public void clickOnLoginBtnOnPopUp(){
        loginBtnOnPopUpAfterChangedPassword.click();
    }

    public void backPassword(){
        currentPasswordEditText.click();
        currentPasswordEditText.sendKeys(environmentConfig.getPasswordToChange());
        newPasswordEditText.click();
        newPasswordEditText.sendKeys(environmentConfig.getPasswordForEmailChange());
        confirmNewPasswordEditText.click();
        confirmNewPasswordEditText.sendKeys(environmentConfig.getPasswordForEmailChange());
    }
}
