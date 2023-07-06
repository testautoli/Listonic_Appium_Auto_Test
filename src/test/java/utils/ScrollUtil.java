package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class ScrollUtil {

    public static void scroll(AppiumDriver driver, ScrollEnum scrollEnum) {
        Dimension dimension = driver.manage().window().getSize();

        int start_x = 0, start_y = 0, end_x = 0, end_y = 0;

        if (scrollEnum == ScrollEnum.DOWN) {
            start_x = (int) (dimension.width * 0.2);
            start_y = (int) (dimension.height * 0.8);
            end_x = (int) (dimension.width * 0.8);
            end_y = (int) (dimension.height * 0.2);
        } else if (scrollEnum == ScrollEnum.UP) {
            start_x = (int) (dimension.width * 0.2);
            start_y = (int) (dimension.height * 0.2);
            end_x = (int) (dimension.width * 0.2);
            end_y = (int) (dimension.height * 0.8);
        }
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y)).release().perform();
    }
}
