package utils;

import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import properities.EnvironmentConfig;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static AndroidDriver<WebElement> driver;


    public static AndroidDriver<WebElement> getDriver() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities cap = new DesiredCapabilities();
            EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

            cap.setCapability(MobileCapabilityType.DEVICE_NAME, environmentConfig.deviceName());
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
//            cap.setCapability(MobileCapabilityType.FULL_RESET, true);
            cap.setCapability(MobileCapabilityType.NO_RESET, false);
            cap.setCapability("appPackage", "com.l.dev");
            cap.setCapability("appActivity", "com.l.ui.activity.MainActivity");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 3700);
        }
        return driver;
    }

    public static void resetDriver(){
        driver = null;
    }
}
