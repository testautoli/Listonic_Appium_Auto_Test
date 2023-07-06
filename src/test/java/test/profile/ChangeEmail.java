package test.profile;

import org.aeonbits.owner.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import properities.EnvironmentConfig;
import test.BaseTest;

public class ChangeEmail extends BaseTest {


    InitialPage initialPage;
    MainPage mainPage;
    AsideMenu asideMenu;
    RegisterPage registerPage;
    CreateAccountPage createAccountPage;
    CreatePasswordPage createPasswordPage;
    SettingsPage settingsPage;
    AccountPage accountPage;
    ChangeAddressEmailPage changeAddressEmailPage;
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
        changeAddressEmailPage = new ChangeAddressEmailPage(driver);

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
    public void changeEmailTest(){
        settingsPage.clickOnChangeEmailAddressButton();
        changeAddressEmailPage.clickAndTapNewAddressEmail();
        changeAddressEmailPage.clickAndTapNewConfirmEmail();
        changeAddressEmailPage.clickAndTapNewPassword();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        changeAddressEmailPage.clickOnConfirmChangeEmailButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(changeAddressEmailPage.checkIfToastEmailChangedIsDisplayed());

    }

    @AfterTest
    public void threadDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        settingsPage.clickOnChangeEmailAddressButton();
        changeAddressEmailPage.clickAndTapNewAddressEmailBack();
        changeAddressEmailPage.clickAndTapNewPassword();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        changeAddressEmailPage.clickOnConfirmChangeEmailButton();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountPage.logOutUser();
        accountPage.clickOnLogOutBtnOnBottomSheet();
    }

}
