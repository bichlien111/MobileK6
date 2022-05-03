package test;

import org.testng.annotations.*;

public class TestNGHook02 {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite_Class 02");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("\t\t--->Before Test_Class 02");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("\t\t\t--->Before Class 02");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\t\t\t\t--->Before Method 02");
    }

    // =================================

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite 02");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("\t\t--->After Test 02");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\t\t\t--->After Class 02");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\t\t\t\t--->After Method 02");
    }

    // =================================

    @Test(priority = 2)
    public void testA() {
        System.out.println("\t\t\t\t\t--->Test A_Class 02");
    }

    @Test(priority = 1)
    public void testB() {
        System.out.println("\t\t\t\t\t--->Test B_Class 02");
    }
}
