package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;

public class AppiumHelper {
    @Attachment
    public static byte[] takeScreenshot() throws MalformedURLException {
        return   ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
