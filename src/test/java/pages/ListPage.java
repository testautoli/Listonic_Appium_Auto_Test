package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExplicitWaitUtil;

public class ListPage {

    public ListPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.widget.TextView[1]")
    private WebElement listNameTextView;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup[2]")
    private WebElement shareIconOnListPage;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.widget.ImageView[3]")
    private WebElement meatballsMenu;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Tooltip close\"]")
    private WebElement tooltipCloseButton;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.widget.ImageView[1]")
    private WebElement backArrowButton;


    public void clickOnBackArrowButton(){
        backArrowButton.click();
    }

    public void closeTooltip(){
        tooltipCloseButton.click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean checkIfMeatballMenuIsDisplayed(){
        ExplicitWaitUtil.waitUntilElementIsVisible(meatballsMenu);
     return meatballsMenu.isDisplayed();
    }

    public boolean checkIfShareIconOnListPageIsDisplayed(){
        ExplicitWaitUtil.waitUntilElementIsVisible(shareIconOnListPage);
        return shareIconOnListPage.isDisplayed();
    }

    public String getNameOfCreatedList(){
        ExplicitWaitUtil.waitUntilElementIsVisible(listNameTextView);
        return listNameTextView.getText();
    }
}
