package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;

import java.net.MalformedURLException;

public class ExplicitWaitUtil {

    private static Logger logger = LoggerFactory.getLogger(ExplicitWaitUtil.class);

    private static WebDriverWait getWebDriverWait() {
        try {
            return new WebDriverWait(DriverFactory.getDriver(), 3);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        try {
            WebDriverWait webDriverWait = getWebDriverWait();
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            logger.info("NO SUCH ELEMENT EXCEPTION");
            throw new SkipException("NO SUCH ELEMENT EXCEPTION");
        }
    }
}
