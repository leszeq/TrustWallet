package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class PasscodePage extends BasePage {

    private final Map<Character, WebElement> keys = new HashMap<>();

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='0']") private WebElement k0;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1']") private WebElement k1;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='2']") private WebElement k2;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='3']") private WebElement k3;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='4']") private WebElement k4;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='5']") private WebElement k5;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='6']") private WebElement k6;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='7']") private WebElement k7;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='8']") private WebElement k8;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='9']") private WebElement k9;

    public PasscodePage() {
        super();
        PageFactory.initElements(driver, this);
        keys.put('0', k0);
        keys.put('1', k1);
        keys.put('2', k2);
        keys.put('3', k3);
        keys.put('4', k4);
        keys.put('5', k5);
        keys.put('6', k6);
        keys.put('7', k7);
        keys.put('8', k8);
        keys.put('9', k9);
    }

    public void enterPasscode(String code) {
        for (char c : code.toCharArray()) {
            WebElement key = keys.get(c);
            if (key == null) throw new IllegalArgumentException("Invalid digit: " + c);
            click(key);
        }
    }

    // workaround for clicking the passcode
    public void clickPasscode() {
        WebElement passCode = driver.findElement(By.xpath("//android.widget.TextView[@text=\"1\"]\n"));
        for (int i = 0; i < 6; i++) {
            passCode.click();
        }
    }
}
