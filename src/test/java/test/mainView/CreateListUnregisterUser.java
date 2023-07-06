package test.mainView;

import org.aeonbits.owner.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.InitialPage;
import pages.ListPage;
import pages.MainPage;
import pages.NewListCreatePage;
import properities.EnvironmentConfig;
import test.BaseTest;
import utils.DriverFactory;

public class CreateListUnregisterUser extends BaseTest {

    InitialPage initialPage;
    MainPage mainPage;
    NewListCreatePage newListCreatePage;
    ListPage listPage;
    EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

    @BeforeTest
    public void before() throws InterruptedException {
        initialPage = new InitialPage(driver);
        mainPage = new MainPage(driver);
        newListCreatePage = new NewListCreatePage(driver);
        listPage = new ListPage(driver);

        initialPage.clickOnSkipBtn();
        driver.navigate().back();
        mainPage.clickOnButtonNoticeAgree();
        Thread.sleep(1200);
        mainPage.closeBottomSheetWithNewFunctionality();
    }

    @Test
    public void createListUnregisterUserTest() {
        mainPage.clickOnCreateNewListButton();
        newListCreatePage.provideNameOfNewList(environmentConfig.getNameOfListCreatedByUnregisteredUser());
        newListCreatePage.clickOnCreateListButton();
        listPage.closeTooltip();
        listPage.closeTooltip();
        listPage.closeTooltip();

        Assert.assertEquals(listPage.getNameOfCreatedList(), environmentConfig.getNameOfListCreatedByUnregisteredUser());
        Assert.assertTrue(listPage.checkIfShareIconOnListPageIsDisplayed());
        Assert.assertTrue(listPage.checkIfMeatballMenuIsDisplayed());
    }

    @AfterTest
    public void threadDown() {
        DriverFactory.resetDriver();
    }
}
