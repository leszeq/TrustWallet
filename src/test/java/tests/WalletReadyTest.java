package tests;

import org.testng.annotations.*;
import pages.*;

public class WalletReadyTest extends BaseTest {

    private WalletReadyPage ready;

    @BeforeMethod
    public void goToWalletReady() {
        new HomePage().clickCreateNewWallet();
        new PasscodePage().clickPasscode();
        new PasscodePage().clickPasscode();
        new NotificationPermissionPage().clickSkip();
        ready = new WalletReadyPage();
    }

    @Test
    public void clickBuyCrypto() {
        ready.clickBuyCrypto();
    }

    @Test
    public void clickDepositCrypto() {
        ready.clickDepositCrypto();
    }
}
