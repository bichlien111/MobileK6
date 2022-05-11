package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected static AppiumDriver<MobileElement> appiumDriver;

    @BeforeTest
    public void initAppiumSession() {
        appiumDriver = DriverFactory.getDriver(Platforms.ANDROID);
    }

    protected AppiumDriver<MobileElement> getAppiumDriver() {
        if(appiumDriver == null) {
            return DriverFactory.getDriver(Platforms.ANDROID);
        }
        return appiumDriver;
    }

    @AfterTest(alwaysRun = true)
    public void quitAppiumSession() {
        appiumDriver.quit();
    }
}
