package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import modules.pages.LoginScreen;

public class LoginScreen_POM_02 {

    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.ANDROID);

        try {
            // Find and click on nav Login button
            MobileElement navLoginBtnElement = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElement.click();

            // Fill the form
            LoginScreen loginScreen = new LoginScreen(driver);
            loginScreen.inputEmail("lien@gmail.com");
            loginScreen.inputPassword("12345678");
            loginScreen.clickLoginBtn();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
