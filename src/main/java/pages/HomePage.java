package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"CreateNewWalletButton\")")
    private WebElement createNewWalletButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ImportWalletButton\")")
    private WebElement importWalletButton;

    public void clickCreateNewWallet() {
        click(createNewWalletButton);
    }

    public void clickImportWallet() {
        click(importWalletButton);
    }

    public boolean isCreateWalletButtonDisplayed() {
        return createNewWalletButton.isDisplayed();
    }
}
