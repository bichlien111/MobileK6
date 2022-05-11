package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.DataObjectBuilder;
import test_data.models.LoginCredData;
import test_flows.authentication.LoginFlow;

import java.util.HashMap;
import java.util.Map;

public class LoginTest {

    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginCredData loginCredData) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.ANDROID);
//        Map<String, String> credData = new HashMap<>();

//        credData.put("abc@", "12345678");
//        credData.put("abc@sth.xyz", "1234567");
//        credData.put("lien@gmail.com", "12345678");

        try {
            String email = loginCredData.getEmail();
            String password = loginCredData.getPassword();
//            for (String email : credData.keySet()) {
            LoginFlow loginFlow = new LoginFlow(appiumDriver, email, password);
            loginFlow.gotoLoginScreen();
            loginFlow.login();
            loginFlow.verifyLogin();
            //}
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

    @DataProvider
    public LoginCredData[] loginCredData() {

        // Build support method to convert from JSON -> Array of Objects

        // Return an array of objects

//        LoginCredData loginCredData01 = new LoginCredData("abc@", "12345678");
//        LoginCredData loginCredData02 = new LoginCredData("abc@sth.xyz", "1234567");
//        LoginCredData loginCredData03 = new LoginCredData("lien@gmail.com", "12345678");
//        return new LoginCredData[]{loginCredData01, loginCredData02, loginCredData03};

        String filePath = "/src/test/java/test_data/authen/LoginCreds.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginCredData[].class);
    }
}
