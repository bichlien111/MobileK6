package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogin {
    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.ANDROID);

        try {
            // Find and click on nav Login button
            MobileElement navLoginBtnElement = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElement.click();

            // Fill the form
            MobileElement userElement = driver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordElement = driver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElement = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            userElement.sendKeys("lien@gmail.com");
            passwordElement.sendKeys("12345678");
            loginBtnElement.click();

            // Get text from login dialog
            WebDriverWait wait = new WebDriverWait(driver, 3L);
            WebElement loginDialogTitleElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            System.out.println("Title: " + loginDialogTitleElement.getText());

        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            // Quit appium session
            driver.quit();
        }
    }
}

