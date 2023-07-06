package utils;

import org.openqa.selenium.net.UrlChecker;

import java.io.IOException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class UnlockPhone {

    static Runtime runtime;

    public static void unlockPhone() {
        runtime = Runtime.getRuntime();
        try {
            Thread.sleep(10000);
            runtime.exec("cmd.exe /c start cmd.exe /k & adb shell input keyevent KEYCODE_POWER " +
                    "& adb shell input swipe 800 400 400 400 & adb shell input text 4126");
            runtime.exec("adb shell input swipe 800 400 400 400");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean waitUntilIsRunning() throws Exception {
        final URL status = new URL("http://127.0.0.1:4723/wd/hub/sessions");
        try {
            new UrlChecker().waitUntilAvailable(1000, MILLISECONDS, status);
            return true;
        } catch (UrlChecker.TimeoutException e) {
            return false;
        }
    }
}
