package test;

import context.Contexts;
import context.WaitMoreThanOneContext;
//import appiumDriver.DriverFactory;
//import appiumDriver.Platforms;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HybridContext {
    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.ANDROID);
        try {

            // Navigate to WebView screen
            By webviewNavBtnSel = MobileBy.AccessibilityId("Webview");
            MobileElement webviewNavBtnEle = appiumDriver.findElement(webviewNavBtnSel);
            webviewNavBtnEle.click();

            // Wait until have more than one context
            WebDriverWait wait = new WebDriverWait(appiumDriver, 15L);
            wait.until(new WaitMoreThanOneContext(appiumDriver));

            // Get all context names
            appiumDriver.getContextHandles().forEach(context ->
                    System.out.println(context));

            // Switch to webview context
            appiumDriver.context(Contexts.WEB_VIEW);

            // Interact on webview elements
            WebElement navToggleBtnEle = appiumDriver.findElementByCssSelector(".navbar__toggle");
            navToggleBtnEle.click();
            List<MobileElement> menuItemElems = appiumDriver.findElementsByCssSelector(".menu__list li a");
            List<MenuItemData> menuItemDataList = new ArrayList<>();
            if (menuItemElems.isEmpty()) {
                throw new RuntimeException("[ERR] There is no list item!");
            }

            for (MobileElement menuItemElem : menuItemElems) {
                String itemText = menuItemElem.getText();
                String itemHref = menuItemElem.getAttribute("href");
                if (itemText.isEmpty()) {
                    menuItemDataList.add(new MenuItemData("Github", itemHref));
                } else {
                    menuItemDataList.add(new MenuItemData(itemText, itemHref));
                }
            }

            System.out.println("==================");
            menuItemDataList.forEach(menuItemData -> {
                System.out.println(menuItemData.getName() + ": " + menuItemData.getHref());
            });

            // Switch back to Native context
            appiumDriver.context(Contexts.NATIVE);

            // Find and click on nav Login button
            System.out.println("Switch to Login App");
            MobileElement navLoginBtnElement = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElement.click();

            // Fill the form
            MobileElement userElement = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordElement = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElement = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            userElement.sendKeys("lien@gmail.com");
            passwordElement.sendKeys("12345678");
            loginBtnElement.click();
            System.out.println("Login successfully");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }

    public static class MenuItemData {
        private String name;
        private String href;

        public MenuItemData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        public String getName() {
            return name;
        }

        public String getHref() {
            return href;
        }
    }
}
