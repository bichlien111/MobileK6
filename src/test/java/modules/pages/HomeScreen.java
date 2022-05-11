package modules.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import modules.components.BottomNavComponent;
import modules.components.LoginFormComponent;

public class HomeScreen {

    private final AppiumDriver<MobileElement> driver;

    public HomeScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public BottomNavComponent bottomNavComponent() {
        return new BottomNavComponent(driver);
    }
}
