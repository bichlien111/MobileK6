package test;

import driver.AppPackages;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.time.Duration;

public class HandleMultipleApps {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.ANDROID);
        try {
            // Login then input credentials > click on Login btn
            MobileElement navLoginBtnElement = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElement.click();

            MobileElement userElement = driver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordElement = driver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElement = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            userElement.sendKeys("lien@gmail.com");
            passwordElement.sendKeys("12345678");
            loginBtnElement.click();

            // Put the app into background ~ pressing Home btn
            driver.runAppInBackground(Duration.ofSeconds(-1));

            // Turn Wi-Fi off ~ switch to another Appium
            driver.activateApp(AppPackages.settings);
            By wifiLabelSel = MobileBy.xpath("//*[@text='Connections']");
            By wifiStatusSel = MobileBy.AccessibilityId("Wi-Fi");

            // Nav to Wi-Fi network list
            MobileElement wifiLabelEle = driver.findElement(wifiLabelSel);
            wifiLabelEle.click();

            // Trigger ON/OFF Wi-Fi network
            MobileElement wifiStatusEle = driver.findElement(wifiStatusSel);
            String wifiStatusStr = wifiStatusEle.getText().trim();
            boolean isWifiOn = wifiStatusStr.equalsIgnoreCase("On");
            if (isWifiOn) {
                wifiStatusEle.click();
            }

            // Come back to the App > interact with other elements
            driver.activateApp(AppPackages.webdriverIO);
            driver.findElement(MobileBy.xpath("//*[@text='OK']")).click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
