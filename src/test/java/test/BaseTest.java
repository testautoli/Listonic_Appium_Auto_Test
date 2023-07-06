package test;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.AppiumServerManagement;
import utils.DriverFactory;
import utils.UnlockPhone;

import java.net.MalformedURLException;

public class BaseTest {

    public AndroidDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        AppiumServerManagement.startServer();
    }

    @BeforeTest
    public void setup() throws MalformedURLException {
        driver = DriverFactory.getDriver();
//        if (driver.isDeviceLocked()) {
//            UnlockPhone.unlockPhone();
//        }
    }

    @AfterSuite
    public void afterSuite() {
        AppiumServerManagement.stopServer();
    }
}

