package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.ref.SoftReference;

public class DataProviderExploring {

    @Test(dataProvider = "getDataSet")
    public void testSth(String text) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        softAssert.assertTrue(true);
        System.out.println(text);
        softAssert.assertAll();
    }

    @DataProvider
    public String[] getDataSet() {
        return new String[]{"Text 01, Text 02, Text 03"};
    }
}
