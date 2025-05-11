package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SystemPermissionPopup extends BasePage {
    private final By allow   = By.id("com.android.permissioncontroller:id/permission_allow_button");
    private final By deny    = By.id("com.android.permissioncontroller:id/permission_deny_button");

    public SystemPermissionPopup(AppiumDriver driver) {
    }

    public void clickAllow() {
        By allowButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
        wait.until(ExpectedConditions.elementToBeClickable(allowButton)).click();
    }
    public void deny()   { click(deny);  }
}
