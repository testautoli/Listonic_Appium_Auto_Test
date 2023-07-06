package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExplicitWaitUtil;

public class AsideMenu {

    public AsideMenu(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.l.dev:id/login_button_header_tv")
    private WebElement loginButtonAsideMenu;

    @FindBy(id = "com.l.dev:id/header_name_tv")
    private WebElement headerNameAsideMenu;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]")
    private WebElement settingsBtnOnAsideMenu;

    public void clickOnSettingsBtn(){
        ExplicitWaitUtil.waitUntilElementIsVisible(settingsBtnOnAsideMenu);
        settingsBtnOnAsideMenu.click();
    }

    public void clickOnLoginButtonOnAsideMenu(){
        loginButtonAsideMenu.click();
    }

    public boolean ifHeaderNameAsideIsDisplayed(){
        return headerNameAsideMenu.isDisplayed();
    }
}
