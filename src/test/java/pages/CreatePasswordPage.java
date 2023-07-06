package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExplicitWaitUtil;

public class CreatePasswordPage {

    public CreatePasswordPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout[1]/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement createPasswordTittle;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout[2]/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.AutoCompleteTextView")
    private WebElement passwordInput;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.view.ViewGroup/" +
            "android.widget.Button")
    private WebElement acceptanceTermAndConditionButton;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/androidx.appcompat.widget.LinearLayoutCompat/" +
            "android.view.ViewGroup/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.Button")
    private WebElement createAccountButton;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout[3]/" +
            "android.view.ViewGroup/android.widget.Button")
    private WebElement logInBtn;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
            "android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
    private WebElement continueBottomGoogleSheetBtn;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/androidx.appcompat.widget.LinearLayoutCompat/" +
            "android.view.ViewGroup/android.widget.TextView")
    private WebElement forgotPasswordTextView;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.view.ViewGroup/" +
            "android.widget.Button")
    private WebElement resetPasswordButtonOnBottomSheet;

    public boolean checkIfResetPasswordButtonIsDisplayed(){
        return resetPasswordButtonOnBottomSheet.isDisplayed();
    }

    public void clickOnForgotPasswordTextView(){
        forgotPasswordTextView.click();
    }

    public void clickOnContinueBottomSheetGoogleBtn(){
        continueBottomGoogleSheetBtn.click();
    }

    public void clickOnLogInBtn(){
        logInBtn.click();
    }


    public boolean checkIfCreatePasswordIsDisplayed() {
        return createPasswordTittle.isDisplayed();
    }

    public void tapPasswordIntoPasswordInput(String pass) {
        ExplicitWaitUtil.waitUntilElementIsVisible(passwordInput);
        passwordInput.sendKeys(pass);
    }

    public void clickOnAcceptanceTermAndConditionButton() {
        ExplicitWaitUtil.waitUntilElementIsVisible(acceptanceTermAndConditionButton);
        acceptanceTermAndConditionButton.click();
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }

}
