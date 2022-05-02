package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import modules.components.BottomNavComponent;
import modules.components.LoginFormComponent;
import modules.pages.LoginScreen;

public class LoginScreen_POM_04 {

    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.ANDROID);

        try {
            // Find and click on nav Login button
            LoginScreen loginScreen = new LoginScreen(driver);
            BottomNavComponent bottomNavComponent = loginScreen.bottomNavComponent();
            bottomNavComponent.clickOnLoginIcon();

            // Fill the form
            LoginFormComponent loginFormComponent = loginScreen.loginFormComponent();
            loginFormComponent.inputEmail("lien@gmail.com");
            loginFormComponent.inputPassword("12345678");
            loginFormComponent.clickLoginBtn();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
