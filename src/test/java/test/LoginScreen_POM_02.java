package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import modules.pages.LoginScreen_01;

public class LoginScreen_POM_02 {

    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.ANDROID);

        try {
            // Find and click on nav Login button
            MobileElement navLoginBtnElement = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElement.click();

            // Fill the form
            LoginScreen_01 loginScreen01 = new LoginScreen_01(driver);
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
