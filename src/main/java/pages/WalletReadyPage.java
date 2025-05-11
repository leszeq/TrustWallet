package pages;

import org.openqa.selenium.By;

public class WalletReadyPage extends BasePage {
    private final By title      = By.xpath("//android.widget.TextView[@text='Brilliant, your wallet is ready!']");
    private final By subtitle   = By.xpath("//android.widget.TextView[@text='Buy or deposit to get started.']");
    private final By buyCrypto  = By.xpath("//android.widget.TextView[@text='Buy Crypto']");
    private final By deposit    = By.xpath("//android.widget.TextView[@text='Deposit Crypto']");
    private final By skip       = By.xpath("//android.widget.TextView[contains(@text,\"Skip\")]");

    public boolean isTitleVisible()    { return isDisplayed(title);    }
    public boolean isSubtitleVisible() { return isDisplayed(subtitle); }
    public void clickBuyCrypto()       { click(buyCrypto);  }
    public void clickDepositCrypto()   { click(deposit);    }
    public void clickSkip()            { click(skip);       }
}
