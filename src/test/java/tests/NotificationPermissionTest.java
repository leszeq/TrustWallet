package tests;

import org.testng.annotations.*;
import pages.*;

import static org.testng.Assert.*;

public class NotificationPermissionTest extends BaseTest {

    private NotificationPermissionPage notif;

    @BeforeMethod
    public void goToNotificationScreen() {
        new HomePage().clickCreateNewWallet();
        new PasscodePage().clickPasscode();
        new PasscodePage().clickPasscode();
        notif = new NotificationPermissionPage();
        notif.waitForPage();
    }

    @Test
    public void verifyUIElements() {
        assertTrue(notif.isHeaderDisplayed());
        assertTrue(notif.isDescDisplayed());
        assertTrue(notif.isEnableBtnDisplayed());
        assertTrue(notif.isSkipBtnDisplayed());
    }

    @Test
    public void skipNotifications() {
        notif.clickSkip();
    }

    @Test
    public void allowNotifications() {
        notif.clickEnable();
        new SystemPermissionPopup().allow();
    }
}
