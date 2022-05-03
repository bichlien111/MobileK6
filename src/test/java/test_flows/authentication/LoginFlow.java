package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import modules.components.LoginFormComponent;
import modules.pages.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {

    private final AppiumDriver<MobileElement> appiumDriver;
    private String emailStr;
    private String passwordStr;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String emailStr, String passwordStr) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        this.emailStr = emailStr;
        this.passwordStr = passwordStr;
    }

    public void login() {
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComp = loginScreen.loginFormComponent();

        if (!emailStr.isEmpty()) {
            MobileElement emailEle = loginFormComp.emailEle();
            emailEle.clear();
            emailEle.sendKeys(emailStr);
        }

        if (!passwordStr.isEmpty()) {
            MobileElement passwordEle = loginFormComp.passEle();
            passwordEle.clear();
            passwordEle.sendKeys(passwordStr);
        }

        loginFormComp.clickLoginBtn();
    }

    public void verifyLogin() {
        boolean isEmailValid = EmailValidator.getInstance().isValid(emailStr);
        boolean isPasswordValid = passwordStr.length() >= 8;

        System.out.printf("Email: %s, %b | Password: %s, %b\n", emailStr, isEmailValid, passwordStr, isPasswordValid);

        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormComp = loginScreen.loginFormComponent();

        if (isEmailValid && isPasswordValid) {
            verifyCorrectLoginCreds(loginFormComp);
        }

        if (!isEmailValid) {
            verifyIncorrectEmailStr(loginFormComp);
        }

        if (!isPasswordValid) {
            verifyIncorrectPasswordStr(loginFormComp);
        }

        System.out.println("========================");
    }

    private void verifyIncorrectEmailStr(LoginFormComponent loginFormComp) {
        String actualInvalidEmail = loginFormComp.getInvalidEmail();
        String expectedInvalidEmail = "Please enter a valid email address.";

        // Verification
//        System.out.println("actualInvalidEmail: " + actualInvalidEmail);
//        System.out.println("expectedInvalidEmail: " + expectedInvalidEmail);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualInvalidEmail, expectedInvalidEmail,
                "[ERR] Invalid email format str incorrect");

        System.out.println("----->>>> After asserting");
        softAssert.assertTrue(false, "[ERR] true !=false");
        softAssert.assertAll();
    }

    private void verifyIncorrectPasswordStr(LoginFormComponent loginFormComp) {
        String actualInvalidPassword = loginFormComp.getInvalidPassword();
        String expectedInvalidPassword = "Please enter at least 8 characters.";

        // Verification
//        System.out.println("actualInvalidPassword: " + actualInvalidPassword);
//        System.out.println("expectedInvalidPassword: " + expectedInvalidPassword);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualInvalidPassword, expectedInvalidPassword,
                "[ERR] Invalid password format str incorrect");

        System.out.println("---->>>> After asserting");
        softAssert.assertTrue(false, "[ERR] true !=false");
        softAssert.assertAll();
    }

    private void verifyCorrectLoginCreds(LoginFormComponent loginFormComp) {
        // TODO: Homework
        String actualCorrectLogin = loginFormComp.getCorrectLogin();
        String expectedCorrectLogin = "Success";

        // Verification
        System.out.println("actualCorrectLogin: " + actualCorrectLogin);
        System.out.println("expectedCorrectLogin: " + expectedCorrectLogin);
    }
}
