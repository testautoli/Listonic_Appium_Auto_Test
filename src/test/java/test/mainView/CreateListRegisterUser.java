package test.mainView;

import org.aeonbits.owner.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import properities.EnvironmentConfig;
import test.BaseTest;
import utils.DriverFactory;

public class CreateListRegisterUser extends BaseTest {

    InitialPage initialPage;
    MainPage mainPage;
    AsideMenu asideMenu;
    RegisterPage registerPage;
    CreateAccountPage createAccountPage;
    CreatePasswordPage createPasswordPage;
    SettingsPage settingsPage;
    AccountPage accountPage;
    NewListCreatePage newListCreatePage;
    ListPage listPage;
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
        newListCreatePage = new NewListCreatePage(driver);
        listPage = new ListPage(driver);

        initialPage.clickOnSkipBtn();
        driver.navigate().back();
        mainPage.clickOnButtonNoticeAgree();
        Thread.sleep(2000);
        mainPage.closeBottomSheetWithNewFunctionality();
        mainPage.clickOnHamburgerMenu();
        asideMenu.clickOnLoginButtonOnAsideMenu();
        registerPage.clickToChangeRegisterLoginTextView();
        registerPage.clickOnLoginByEmailBtn();
        createAccountPage.provideEmailIntoEmailInput(environmentConfig.getCorrectRegisterUserEmail());
        createAccountPage.clickOnNextButtonOnCreateAccountPage();
        createPasswordPage.tapPasswordIntoPasswordInput(environmentConfig.getCorrectPasswordRegisterUser());
        createPasswordPage.clickOnLogInBtn();
    }

    @Test
    public void createListRegisterUserTest() {
        mainPage.clickOnCreateNewListButton();
        newListCreatePage.provideNameOfNewList(environmentConfig.getNameOfListCreatedByRegisteredUser());
        newListCreatePage.clickOnCreateListButton();
        listPage.closeTooltip();
        listPage.closeTooltip();
        listPage.closeTooltip();

        Assert.assertEquals(listPage.getNameOfCreatedList(), environmentConfig.getNameOfListCreatedByRegisteredUser());
        Assert.assertTrue(listPage.checkIfShareIconOnListPageIsDisplayed());
        Assert.assertTrue(listPage.checkIfMeatballMenuIsDisplayed());

        listPage.clickOnBackArrowButton();
        Assert.assertTrue(mainPage.checkIfDotMenuOnSingleListIsDisplayed());
    }

    @AfterTest
    public void threadDown() {
        mainPage.clickOnDotMenuOnSingleList();
        mainPage.clickOnDeleteListButton();
        mainPage.clickOnHamburgerMenu();
        asideMenu.clickOnSettingsBtn();
        settingsPage.clickOnLoggedEmailUserTextView();
        accountPage.logOutUser();
        accountPage.clickOnLogOutBtnOnBottomSheet();
        DriverFactory.resetDriver();
    }
}
