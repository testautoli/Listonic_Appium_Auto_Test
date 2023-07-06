package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExplicitWaitUtil;

public class AccountPage {

    public AccountPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout[2]/" +
            "androidx.cardview.widget.CardView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/" +
            "android.view.ViewGroup/android.widget.TextView")
    private WebElement deleteAccountBtn;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.Button")
    private WebElement deleteAccountBtnOnBottomBarAccountPage;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout[2]/" +
            "androidx.cardview.widget.CardView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/" +
            "androidx.appcompat.widget.LinearLayoutCompat/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]")
    private WebElement logOutUserBtn;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.view.ViewGroup/" +
            "android.widget.Button")
    private WebElement logOutBtoOnBottomSheet;


    public void logOutUser(){
        logOutUserBtn.click();
    }

    public void clickOnLogOutBtnOnBottomSheet(){
        logOutBtoOnBottomSheet.click();
    }


    public void clickOnDeleteAccountBtn(){
        ExplicitWaitUtil.waitUntilElementIsVisible(deleteAccountBtn);
        deleteAccountBtn.click();
    }

    public void clickOnDeleteAccountOnBottomBar(){
        ExplicitWaitUtil.waitUntilElementIsVisible(deleteAccountBtnOnBottomBarAccountPage);
        deleteAccountBtnOnBottomBarAccountPage.click();
    }
}
