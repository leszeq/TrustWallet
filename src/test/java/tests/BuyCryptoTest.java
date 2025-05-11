package tests;

import org.testng.annotations.*;
import pages.*;

public class BuyCryptoTest extends BaseTest {

    private BuyCryptoPage buy;

    @BeforeMethod
    public void goToBuyCrypto() {
        new HomePage().clickCreateNewWallet();
        new PasscodePage().clickPasscode();
        new PasscodePage().clickPasscode();
        new NotificationPermissionPage().clickSkip();
        new WalletReadyPage().clickBuyCrypto();
        buy = new BuyCryptoPage();
        buy.waitForPage();
    }

    @Test
    public void testBuyNowButton() {
        buy.clickBuyNow();
    }
}
