package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import modules.components.BottomNavComponent;
import modules.pages.LoginScreen_01;

public class LoginScreen_POM_03 {

    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.ANDROID);

        try {
            // Find and click on nav Login button
            LoginScreen_01 loginScreen01 = new LoginScreen_01(driver);
            BottomNavComponent bottomNavComponent = loginScreen01.bottomNavComponent();
            bottomNavComponent.clickOnLoginIcon();

            // Fill the form
            loginScreen01.inputEmail("lien@gmail.com");
            loginScreen01.inputPassword("12345678");
            loginScreen01.clickLoginBtn();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
