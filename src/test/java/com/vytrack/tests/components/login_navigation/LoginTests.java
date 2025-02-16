package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginTest1() {
        extentLogger = report.createTest("Login as store manager");

        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        pages.loginPage().clickRememberMe();
        pages.loginPage().login(username, password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "Dashboard");
        extentLogger.pass("Verified page name: " + pages.dashboardPage().getPageSubTitle());
    }

    @Test(description = "Login with invalid credentials and verify warning message")
    public void negativeLoginTest1() {
        extentLogger = report.createTest("Negative login test");
        extentLogger.info("Login with wrongusername username and wrongpassword password");
        pages.loginPage().login("wrongusername", "wrongpassword");
        Assert.assertEquals(pages.loginPage().getErrorMessage(), "Invalid user name or password.");
        extentLogger.pass("Verified that Message present: " + pages.loginPage().getErrorMessage());
    }
    @Test
    @Parameters({ "username", "password" }) // get data from data testng.xml
    public void loginWithParameters3(@Optional String username, @Optional String password) {
        extentLogger = report.createTest("Login as store manager");
        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        pages.loginPage().clickRememberMe();
        pages.loginPage().login(username, password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "Dashboard");
        extentLogger.pass("Verified page name: " + pages.dashboardPage().getPageSubTitle());
    }

//    @Test
//    @Parameters({ "username", "password" }) // get data from data testng.xml
//    public void loginWithParameters(String username, String password) {
//        extentLogger = report.createTest("Login as store manager");
//
//        //we are instantiating page class inside a tests class,
//        //because for second test, if we run all tests in a row, driver will have null session
//        pages.loginPage().clickRememberMe();
//        pages.loginPage().login(username, password);
//        //to verify that Dashboard page opened
//        //Once page name Dashboard displays, means that we are logged successfully
//        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "Dashboard");
//        extentLogger.pass("Verified page name: " + pages.dashboardPage().getPageSubTitle());
//        BrowserUtils.getScreenshot("Test");
//    }
@Test
@Parameters({ "username", "password" }) // get data from data testng.xml
public void loginWithParameters(@Optional String username, @Optional String password) {
    extentLogger = report.createTest("Login as store manager");
    //@Optional tak will make testng parameter optional
    //but, if there is no value - you will null
    //thus, let's make sure parameters are not null
    //if so, let's pull credentials from properties
    if(username == null){
        username = ConfigurationReader.getProperty("storemanagerusername");
        password = ConfigurationReader.getProperty("storemanagerpassword");
    }
    //we are instantiating page class inside a tests class,
    //because for second test, if we run all tests in a row, driver will have null session
    pages.loginPage().clickRememberMe();
    pages.loginPage().login(username, password);
    //to verify that Dashboard page opened
    //Once page name Dashboard displays, means that we are logged successfully
    Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "Dashboard");
    extentLogger.pass("Verified page name: " + pages.dashboardPage().getPageSubTitle());
}


    @Test(dataProvider = "credentials_info") // get data from data provider
    public void loginWithDataProvider(String username, String password) {
        extentLogger = report.createTest("Login as store manager");
        System.out.println(username+"  ::  "+password);
        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        pages.loginPage().clickRememberMe();
        pages.loginPage().login(username, password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        Assert.assertEquals(pages.dashboardPage().getPageSubTitle(), "Dashboard");
        extentLogger.pass("Verified page name: " + pages.dashboardPage().getPageSubTitle());
    }

    @DataProvider(name = "credentials_info")
    public static Object[][] credentials() {
        return new Object[][] { { "storemanager85", "UserUser123" },
                                { "salesmanager110", "UserUser123" },
                                { "salesmanager133", "UserUser123" },
                                { "salesmanager65", "UserUser123" }};

    }


    @Test(description = "Login with invalid credentials and verify warning message")
    public void negativeLoginTest2() {
        extentLogger = report.createTest("Negative login test");
        extentLogger.info("Login with wrongusername username and wrongpassword password");
        pages.loginPage().login("wrongusername", "wrongpassword");
        softAssert.assertEquals(pages.loginPage().getErrorMessage(), "Invalid user name or password.");
        extentLogger.pass("Verified that Message present: " + pages.loginPage().getErrorMessage());
    }


}
