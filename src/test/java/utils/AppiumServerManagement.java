package utils;

import java.io.IOException;

public class AppiumServerManagement {
    static Runtime runtime;

    public static void startServer() {
        runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
            Thread.sleep(20000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void stopServer() {
        runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
//            runtime.exec("taskkill /F /IM cmd.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
