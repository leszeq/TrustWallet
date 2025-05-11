package pages;

import org.openqa.selenium.By;

public class SystemPermissionPopup extends BasePage {
    private final By allow   = By.id("com.android.permissioncontroller:id/permission_allow_button");
    private final By deny    = By.id("com.android.permissioncontroller:id/permission_deny_button");

    public void allow()  { click(allow); }
    public void deny()   { click(deny);  }
}
