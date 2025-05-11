package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BuyCryptoPage extends BasePage {

    @AndroidFindBy(id = "amountSelector")      private WebElement amountField;
    @AndroidFindBy(id = "cryptoEstimate")      private WebElement estimateText;
    @AndroidFindBy(accessibility = "Back")     private WebElement backButton;
    @AndroidFindBy(id = "toolbarTitle")        private WebElement titleText;

    private final By buyNowBtn = By.xpath("//android.widget.TextView[contains(@text,'Buy Now')]");

    public void waitForPage() {
        wait.until(driver -> isDisplayed(buyNowBtn) || amountField.isDisplayed());
    }

    public String getTitle() {
        return titleText.getText();
    }

    public void setAmount(String amount) {
        amountField.clear();
        amountField.sendKeys(amount);
    }

    public String getEstimate() {
        return estimateText.getText();
    }

    public void goBack() {
        click(backButton);
    }

    public void clickBuyNow() {
        click(buyNowBtn);
    }
}
