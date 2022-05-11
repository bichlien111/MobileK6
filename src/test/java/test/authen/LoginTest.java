package test.authen;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.DataObjectBuilder;
import test_data.models.LoginCredData;
import test_flows.authentication.LoginFlow;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginCredData loginCredData) {

        System.out.println("--> Session ID: " + appiumDriver.getSessionId());
        String email = loginCredData.getEmail();
        String password = loginCredData.getPassword();
        LoginFlow loginFlow = new LoginFlow(appiumDriver, email, password);
        loginFlow.gotoLoginScreen();
        loginFlow.login();
        loginFlow.verifyLogin();
    }

    @DataProvider
    public LoginCredData[] loginCredData() {
        String filePath = "/src/test/java/test_data/authen/LoginCreds.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginCredData[].class);
    }
}
