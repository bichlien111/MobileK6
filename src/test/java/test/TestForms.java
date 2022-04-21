package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestForms {

    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.ANDROID);

        try {
            // Find and click on Forms button
            MobileElement navFormBtnElem = driver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormBtnElem.click();

            // Wait until on Form screen
            WebDriverWait wait = new WebDriverWait(driver, 5L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    MobileBy.xpath("//android.widget.TextView[contains(@text, \"Form components\")]")));

            // Get Mobile window size
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate Touch points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 50 * screenHeight / 100;
            int yEndPoint = 10 * screenHeight / 100;

            // Convert coordinates -> PointOption
            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            // Using TouchAction to swipe
            TouchAction touchAction = new TouchAction(driver);
            touchAction
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            // Swipe down
            touchAction
                    .longPress(endPoint)
                    .moveTo(startPoint)
                    .release()
                    .perform();

            touchAction
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            // Input field
            MobileElement inputFieldElem = driver.findElement(MobileBy.AccessibilityId("text-input"));
            inputFieldElem.click();
                // Hide virtual keyboard
            MobileElement virtualKeyboardElem = driver.findElement(
                    MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"));
            virtualKeyboardElem.click();
                // Input text to field
            inputFieldElem.sendKeys("Test nha");

            // Verify typed text
            MobileElement inputResultElem = driver.findElement(MobileBy.AccessibilityId("input-text-result"));
            if (inputResultElem.getText().equals(inputFieldElem.getText())) {
                System.out.println("You have typed: " + inputResultElem.getText());
            } else {
                System.out.println("Different text with input field");
            }

            // Switch mode ON or OFF
            MobileElement switchElem = driver.findElement(MobileBy.AccessibilityId("switch"));
            switchElem.click();
            System.out.println("Mode is: " + switchElem.getText());

            // Choose item into Dropdown list
            MobileElement dropDownElem = driver.findElement(MobileBy.AccessibilityId("Dropdown"));
            dropDownElem.click();
            MobileElement firstItemDropDownList = driver.findElement(
                    MobileBy.xpath("//android.widget.CheckedTextView[contains(@text, \"webdriver.io is awesome\")]"));
            firstItemDropDownList.click();

            // Click on Active button
            driver.findElement(MobileBy.AccessibilityId("button-Active")).click();
            System.out.println("Active");

            // Click on OK button
            driver.findElement(MobileBy.id("android:id/button1")).click();
            System.out.println("OK");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}