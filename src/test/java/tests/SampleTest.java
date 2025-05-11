package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.*;

public class SampleTest extends BaseTest {

    @Test
    public void createWalletButtonAppears() {
        HomePage home = new HomePage();
        assertTrue(home.isCreateWalletButtonDisplayed());
        home.clickCreateNewWallet();
    }
}
