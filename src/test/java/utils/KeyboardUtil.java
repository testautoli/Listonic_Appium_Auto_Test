package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class KeyboardUtil {

    private static boolean checkIfKeyboardsShown(AndroidDriver<AndroidElement> driver) {
        return driver.isKeyboardShown();
    }

    public static void hideKeyboard(AndroidDriver<AndroidElement> driver) {
        if (checkIfKeyboardsShown(driver))
            driver.hideKeyboard();
    }
}
