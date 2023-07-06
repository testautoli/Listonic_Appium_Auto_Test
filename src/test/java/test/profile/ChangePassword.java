package test.profile;

import org.aeonbits.owner.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import properities.EnvironmentConfig;
import test.BaseTest;

public class ChangePassword extends BaseTest {

    InitialPage initialPage;
    MainPage mainPage;
    AsideMenu asideMenu;
    RegisterPage registerPage;
    CreateAccountPage createAccountPage;
    CreatePasswordPage createPasswordPage;
    SettingsPage settingsPage;
    AccountPage accountPage;
    ChangePasswordPage changePasswordPage;
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
        changePasswordPage = new ChangePasswordPage(driver);

        initialPage.clickOnSkipBtn();
        driver.navigate().back();
        mainPage.clickOnButtonNoticeAgree();
        Thread.sleep(2000);
        mainPage.closeBottomSheetWithNewFunctionality();
        mainPage.clickOnHamburgerMenu();
        asideMenu.clickOnLoginButtonOnAsideMenu();
        registerPage.clickToChangeRegisterLoginTextView();
        registerPage.clickOnLoginByEmailBtn();
        createAccountPage.provideEmailIntoEmailInput(environmentConfig.getEmailForChange());
        createAccountPage.clickOnNextButtonOnCreateAccountPage();
        createPasswordPage.tapPasswordIntoPasswordInput(environmentConfig.getPasswordForEmailChange());
        createPasswordPage.clickOnLogInBtn();
        mainPage.clickOnHamburgerMenu();
        asideMenu.clickOnSettingsBtn();
        settingsPage.clickOnLoggedEmailUserTextView();
    }

    @Test
    public void changePasswordTest() {
        settingsPage.clickOnChangePasswordButton();
        changePasswordPage.clickAndTapCurrentPassword();
        changePasswordPage.clickAndTapNewPassword();
        changePasswordPage.clickAndTapConfirmNewPassword();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        changePasswordPage.clickConfirmButtonToChangePassword();
        Assert.assertTrue(changePasswordPage.checkIfPopUpAfterChangedPasswordIsDisplayed());
    }

    @AfterTest
    public void threadDown() {
        changePasswordPage.clickOnLoginBtnOnPopUp();
        registerPage.clickToChangeRegisterLoginTextView();
        registerPage.clickOnLoginByEmailBtn();
        createAccountPage.provideEmailIntoEmailInput(environmentConfig.getEmailForChange());
        createAccountPage.clickOnNextButtonOnCreateAccountPage();
        Assert.assertTrue(createPasswordPage.checkIfCreatePasswordIsDisplayed());
        createPasswordPage.tapPasswordIntoPasswordInput(environmentConfig.getPasswordToChange());
        createPasswordPage.clickOnLogInBtn();
        mainPage.clickOnHamburgerMenu();
        asideMenu.clickOnSettingsBtn();
        settingsPage.clickOnLoggedEmailUserTextView();
        settingsPage.clickOnChangePasswordButton();
        changePasswordPage.backPassword();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        changePasswordPage.clickConfirmButtonToChangePassword();
    }
}
