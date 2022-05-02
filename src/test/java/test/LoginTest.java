package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import test_flows.authentication.LoginFlow;

import java.util.HashMap;
import java.util.Map;

public class LoginTest {

    @Test
    public void testLogin() {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.ANDROID);
        Map<String, String> credData = new HashMap<>();

        credData.put("abc@", "12345678");
        credData.put("abc@sth.xyz", "1234567");
        credData.put("lien@gmail.com", "12345678");

        try {
            for (String email : credData.keySet()) {
                LoginFlow loginFlow = new LoginFlow(appiumDriver, email, credData.get(email));
                loginFlow.gotoLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }

//    private static void loginWithCreds(
//            AppiumDriver<MobileElement> appiumDriver, String emailStr, String passwordStr) {
//        LoginFlow loginFlow = new LoginFlow(appiumDriver, emailStr, passwordStr);
//        loginFlow.gotoLoginScreen();
//        loginFlow.login();
//        loginFlow.verifyLogin();
//    }
}
