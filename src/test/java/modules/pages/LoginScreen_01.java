package modules.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import modules.components.BottomNavComponent;
import org.openqa.selenium.By;

public class LoginScreen_01 {

    private final AppiumDriver<MobileElement> driver;
    private final static By emailSel = MobileBy.AccessibilityId("input-email");
    private final static By passSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginScreen_01(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MobileElement emailEle() {
        return driver.findElement(emailSel);
    }

    public MobileElement passEle() {
        return driver.findElement(passSel);
    }

    public MobileElement loginEle() {
        return driver.findElement(loginBtnSel);
    }

    public void inputEmail(String email) {
        if (!email.isEmpty()) {
            emailEle().sendKeys(email);
        }
    }

    public void inputPassword(String password) {
        if (!password.isEmpty()) {
            passEle().sendKeys(password);
        }
    }

    public void clickLoginBtn() {
        loginEle().click();
    }

    public BottomNavComponent bottomNavComponent() {
        return new BottomNavComponent(driver);
    }
}
