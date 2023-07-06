package test.singInSingUp;

import org.aeonbits.owner.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import properities.EnvironmentConfig;
import test.BaseTest;
import utils.DriverFactory;

import java.util.concurrent.TimeoutException;

public class SingUpWithGoogle extends BaseTest {

    InitialPage initialPage;
    MainPage mainPage;
    AsideMenu asideMenu;
    RegisterPage registerPage;
    CreateAccountPage createAccountPage;
    CreatePasswordPage createPasswordPage;
    SettingsPage settingsPage;
    AccountPage accountPage;
    EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

    @BeforeTest
    public void before() throws InterruptedException {
        initialPage = new InitialPage(driver);
        mainPage = new MainPage(driver);
        asideMenu = new AsideMenu(driver);
        registerPage = new RegisterPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        createPasswordPage = new CreatePasswordPage(driver);
        settingsPage = new SettingsPage(driver);
        accountPage = new AccountPage(driver);

        initialPage.clickOnSkipBtn();
        driver.navigate().back();
        mainPage.clickOnButtonNoticeAgree();
        Thread.sleep(2000);
        mainPage.closeBottomSheetWithNewFunctionality();
    }

    @Test
    public void singUpWithGoogleTest(){
        mainPage.clickOnHamburgerMenu();
        Assert.assertTrue(asideMenu.ifHeaderNameAsideIsDisplayed());
        asideMenu.clickOnLoginButtonOnAsideMenu();
        Assert.assertTrue(registerPage.checkIfRegisterToolbarTittleIsDisplayed());
        registerPage.clickOnRegisterByGoogleButton();
        createPasswordPage.clickOnAcceptanceTermAndConditionButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createPasswordPage.clickOnContinueBottomSheetGoogleBtn();
        mainPage.clickOnHamburgerMenu();
        asideMenu.clickOnSettingsBtn();
        //TODO
//        Assert.assertTrue(settingsPage.checkIfLoggedInByGoogleEmail());
    }

    @AfterTest
    public void threadDown() {
        settingsPage.clickOnLoggedEmailUserByGoogleTextView();
        accountPage.clickOnDeleteAccountBtn();
        accountPage.clickOnDeleteAccountOnBottomBar();
        DriverFactory.resetDriver();
    }
}
