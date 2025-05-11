package pages;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

public class NotificationPermissionPage extends BasePage {

    private final By header     = By.xpath("//android.widget.TextView[@text='Enable Notifications']");
    private final By desc       = By.xpath("//android.widget.TextView[contains(@text,'Turn on') or contains(@text,'notifications')]");
    private final By enableBtn  = By.xpath("//android.widget.TextView[contains(@text,'Enable Notifications')]");
    private final By skipBtn    = By.xpath("//android.widget.TextView[contains(@text,'Skip')]");

    public void waitForPage() {
        wait.until(driver -> isDisplayed(header) || isDisplayed(skipBtn));
    }

    public boolean isHeaderDisplayed()    { return isDisplayed(header); }
    public boolean isDescDisplayed()      { return isDisplayed(desc); }
    public boolean isEnableBtnDisplayed() { return isDisplayed(enableBtn); }
    public boolean isSkipBtnDisplayed()   { return isDisplayed(skipBtn); }

    public void clickEnable() {
        try {
            click(enableBtn);
        } catch (Exception e) {
            new TouchAction<>((PerformsTouchActions) driver)
                    .tap(PointOption.point(600,1800))
                    .perform();
        }
    }

    public void clickSkip() {
        try {
            click(skipBtn);
        } catch (Exception e) {
            new TouchAction<>((PerformsTouchActions) driver)
                    .tap(PointOption.point(600,2300))
                    .perform();
        }
    }
}
