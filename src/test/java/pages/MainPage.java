package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExplicitWaitUtil;

public class MainPage {

    public MainPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Zgódź się i zamknij\"]")
    WebElement buttonNoticeAgree;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/" +
            "android.view.View[2]/android.widget.Button")
    private WebElement maybeLatterBtn;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    private WebElement toolbarHomeMenu;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.Button")
    private WebElement createNewListButton;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/" +
            "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.cardview.widget.CardView/" +
            "android.view.ViewGroup/android.widget.ImageView")
    private WebElement dotMenuOnSingleList;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/" +
            "android.view.View[2]/android.view.View[4]")
    private WebElement deleteListButton;


    public void clickOnDeleteListButton() {
        deleteListButton.click();
    }

    public boolean checkIfDotMenuOnSingleListIsDisplayed() {
        return dotMenuOnSingleList.isDisplayed();
    }

    public void clickOnDotMenuOnSingleList() {
        ExplicitWaitUtil.waitUntilElementIsVisible(dotMenuOnSingleList);
        dotMenuOnSingleList.click();
    }

    public void clickOnCreateNewListButton() {
        createNewListButton.click();
    }

    public void clickOnButtonNoticeAgree() {
        ExplicitWaitUtil.waitUntilElementIsVisible(buttonNoticeAgree);
        buttonNoticeAgree.click();
    }

    public void closeBottomSheetWithNewFunctionality() {
        maybeLatterBtn.click();
    }

    public void clickOnHamburgerMenu() {
        ExplicitWaitUtil.waitUntilElementIsVisible(toolbarHomeMenu);
        toolbarHomeMenu.click();
    }
}
