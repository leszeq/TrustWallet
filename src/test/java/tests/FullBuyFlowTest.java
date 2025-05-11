package tests;

import org.testng.annotations.*;
import pages.*;

public class FullBuyFlowTest extends BaseTest {

    @Test
    public void fullFlowToMoonPay() {
        new HomePage().clickCreateNewWallet();
        new PasscodePage().clickPasscode();
        new PasscodePage().clickPasscode();
        new NotificationPermissionPage().clickSkip();
        new WalletReadyPage().clickBuyCrypto();
        BuyCryptoPage buyCryptoPage = new BuyCryptoPage();
        buyCryptoPage.waitForPage();
        buyCryptoPage.clickBuyNow();
        MoonPaySignInPage moon = new MoonPaySignInPage();
        moon.switchToWebView();
        moon.waitForPage();
    }
}
