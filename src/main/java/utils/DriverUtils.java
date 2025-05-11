package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {

    public static AppiumDriver driver;

    public static void initializeDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "16");
        caps.setCapability("deviceName", "Pixel 6");
        caps.setCapability("app", new File("src/test/resources/latest.apk").getAbsolutePath());
        caps.setCapability("appPackage", "com.wallet.crypto.trustapp");
        caps.setCapability("appActivity", "com.wallet.crypto.trustapp.ui.app.AppActivity");
        caps.setCapability("automationName", "UiAutomator2");
        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4725/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        }
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Please call initializeDriver first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
