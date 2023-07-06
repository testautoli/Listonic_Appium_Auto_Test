package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

public class FailureListener implements ITestListener {

    public void onTestFailure(ITestResult result) {

        String uiid = UUID.randomUUID().toString();

        File file = null;
        try {
            file = DriverFactory.getDriver().getScreenshotAs(OutputType.FILE);
        } catch (MalformedURLException e) {
            System.out.println("Nie udało się zrobic zrzutu ekranu");
        }
        try {
            FileUtils.copyFile(file, new File("src/test/resources/" + uiid + "screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
