package pages;

import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properities.EnvironmentConfig;
import utils.ExplicitWaitUtil;

public class SettingsPage {

    EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

    public SettingsPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/" +
            "android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.TextView[2]")
    private WebElement loggedEmailUser;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/" +
            "android.view.View/android.view.View/android.view.View[1]/android.view.View[1]")
    private WebElement loggedEmailUserByGoogle;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout[2]/" +
            "androidx.cardview.widget.CardView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/" +
            "android.widget.TextView")
    private WebElement changeEmailAddressButton;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout[2]/" +
            "androidx.cardview.widget.CardView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]")
    private WebElement changePasswordButton;


    public void clickOnChangePasswordButton() {
        changePasswordButton.click();
    }

    public void clickOnChangeEmailAddressButton() {
        changeEmailAddressButton.click();
    }

    public boolean checkIfLoggedSameAsLoginEmail() {
        return loggedEmailUser.getText().equals(environmentConfig.getCorrectEmail());
    }

    public boolean checkIfLoggedSameAsLoggedRegisterUser() {
        return loggedEmailUser.getText().equals(environmentConfig.getCorrectRegisterUserEmail());
    }

    public boolean checkIfLoggedInByGoogleEmail() {
        return loggedEmailUserByGoogle.getText().equals(environmentConfig.getCorrectEmailByGoogle());
    }

    public void clickOnLoggedEmailUserTextView() {
        ExplicitWaitUtil.waitUntilElementIsVisible(loggedEmailUser);
        loggedEmailUser.click();
    }

    public void clickOnLoggedEmailUserByGoogleTextView() {
        ExplicitWaitUtil.waitUntilElementIsVisible(loggedEmailUserByGoogle);
        loggedEmailUserByGoogle.click();
    }
}
