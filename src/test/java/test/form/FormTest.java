package test.form;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.BaseFlow;
import test_flows.form.FormFlow;

public class FormTest extends BaseTest {

    @Test
    public void testFormInput() {
        FormFlow formFlow = new FormFlow(getAppiumDriver());
        formFlow.gotoFormScreen();
        formFlow.fillTheForm();
        formFlow.verifyFormDisplay();
    }
}
