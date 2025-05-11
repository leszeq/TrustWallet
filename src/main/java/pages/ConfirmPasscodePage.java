package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class ConfirmPasscodePage {

    private AppiumDriver driver;

    @FindBy(xpath = "//android.widget.TextView[@text='Those passwords didn’t match!']")
    private WebElement errorMessage;

    public ConfirmPasscodePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Metoda pomocnicza do kliknięcia w przycisk z konkretną cyfrą
    private void tapDigit(char digit) {
        String digitStr = String.valueOf(digit);
        WebElement number = driver.findElement(By.xpath("//android.widget.TextView[@text='" + digitStr + "']"));
        number.click();
    }

    // Wpisuje pełny kod (np. "123456")
    public void enterPasscode(String passcode) {
        for (char digit : passcode.toCharArray()) {
            tapDigit(digit);
        }
    }
}
