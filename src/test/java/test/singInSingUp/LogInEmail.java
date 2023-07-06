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

public class LogInEmail extends BaseTest {

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
    public void LogInEmailTest() {
        mainPage.clickOnHamburgerMenu();
        Assert.assertTrue(asideMenu.ifHeaderNameAsideIsDisplayed());
        asideMenu.clickOnLoginButtonOnAsideMenu();
        Assert.assertTrue(registerPage.checkIfRegisterToolbarTittleIsDisplayed());
        registerPage.clickToChangeRegisterLoginTextView();
        registerPage.clickOnLoginByEmailBtn();
        createAccountPage.provideEmailIntoEmailInput(environmentConfig.getCorrectRegisterUserEmail());
        createAccountPage.clickOnNextButtonOnCreateAccountPage();
        Assert.assertTrue(createPasswordPage.checkIfCreatePasswordIsDisplayed());
        createPasswordPage.tapPasswordIntoPasswordInput(environmentConfig.getCorrectPasswordRegisterUser());
        createPasswordPage.clickOnLogInBtn();
        mainPage.clickOnHamburgerMenu();
        asideMenu.clickOnSettingsBtn();
        Assert.assertTrue(settingsPage.checkIfLoggedSameAsLoggedRegisterUser());
    }

    @AfterTest
    public void threadDown() {
        settingsPage.clickOnLoggedEmailUserTextView();
        accountPage.logOutUser();
        accountPage.clickOnLogOutBtnOnBottomSheet();
        DriverFactory.resetDriver();
    }

}
