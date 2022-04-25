package modules.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import modules.components.BottomNavComponent;
import modules.components.LoginFormComponent;

public class LoginScreen_02 {

    private final AppiumDriver<MobileElement> driver;

    public LoginScreen_02(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public LoginFormComponent loginFormComponent() {
        return new LoginFormComponent(driver);
    }

    public BottomNavComponent bottomNavComponent() {
        return new BottomNavComponent(driver);
    }
}
