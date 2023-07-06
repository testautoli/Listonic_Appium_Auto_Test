package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExplicitWaitUtil;

public class RegisterPage {

    public RegisterPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout[1]/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement registerToolbarTittle;

    @FindBy(xpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout[4]/" +
            "android.view.ViewGroup/android.widget.Button")
    private WebElement registerByEmailButton;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout[3]/" +
            "android.view.ViewGroup/android.widget.Button")
    private WebElement registerByGoogleAccountButton;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.TextView")
    private WebElement changeLoginInRegisterTextView;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout[4]/" +
            "android.view.ViewGroup/android.widget.Button")
    private WebElement loginByEmailBtn;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.Button")
    private WebElement loginByGoogleAccount;

    public void clickOnLoginGoogleAccountBtn(){
        loginByGoogleAccount.click();
    }

    public boolean checkIfRegisterToolbarTittleIsDisplayed(){
        return registerToolbarTittle.isDisplayed();
    }

    public void clickOnRegisterByEmailButton(){
        registerByEmailButton.click();
    }

    public  void clickOnRegisterByGoogleButton(){
        registerByGoogleAccountButton.click();
    }

    public void clickToChangeRegisterLoginTextView(){
        changeLoginInRegisterTextView.click();
    }

    public void clickOnLoginByEmailBtn(){
        ExplicitWaitUtil.waitUntilElementIsVisible(loginByEmailBtn);
        loginByEmailBtn.click();
    }
}