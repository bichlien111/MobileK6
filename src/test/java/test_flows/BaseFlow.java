package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import modules.pages.LoginScreen_01;

public class BaseFlow {

    private final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void gotoLoginScreen() {
        new LoginScreen_01(appiumDriver).bottomNavComponent().clickOnLoginIcon();
    }
}
