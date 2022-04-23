package test;

import appiumDriver.DriverFactory;
import appiumDriver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;

public class TakingScreenshot {
    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.ANDROID);
        try {

            MobileElement navLoginBtnElement = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElement.click();

            // Whole screen
            File base64ScreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("HomeScreen.png");
            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));

            // An area - Login Form
            MobileElement loginFormElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            File bas64LoginFormData = loginFormElem.getScreenshotAs(OutputType.FILE);
            String loginFormFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginForm.png");
            FileUtils.copyFile(bas64LoginFormData, new File(loginFormFileLocation));

            // An element - Login Button
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            File bas64LoginBtnData = loginBtnElem.getScreenshotAs(OutputType.FILE);
            String loginBtnFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginBtn.png");
            FileUtils.copyFile(bas64LoginBtnData, new File(loginBtnFileLocation));

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

        }
    }
}
