package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MoonPaySignInPage extends BasePage {
    private final By signInText = By.xpath("//android.widget.TextView[contains(@text,'Sign in with MoonPay')]");
    private final By emailField = By.className("android.widget.EditText");
    private final By continueBtn= By.xpath("//android.widget.Button[@text='Continue']");

    public void switchToWebView() {
        if (driver instanceof ContextAware) {
            for (String ctx : ((ContextAware)driver).getContextHandles()) {
                if (ctx.toLowerCase().contains("webview")) {
                    ((ContextAware)driver).context(ctx);
                    return;
                }
            }
            throw new RuntimeException("WebView context not found");
        }
    }

    public void waitForPage() {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(signInText),
                ExpectedConditions.visibilityOfElementLocated(continueBtn)
        ));
    }

    public boolean isSignInTextVisible()   { return isDisplayed(signInText);   }
    public boolean isEmailFieldVisible()   { return isDisplayed(emailField);   }
    public boolean isContinueBtnVisible()  { return isDisplayed(continueBtn);  }

    public void clickContinue() {
        click(continueBtn);
    }
}
