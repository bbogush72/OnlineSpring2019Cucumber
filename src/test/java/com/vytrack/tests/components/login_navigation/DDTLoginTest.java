package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.ExcelUtil;
import com.vytrack.utilities.Pages;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTLoginTest {

    @Test(dataProvider = "credentials_info")
    public void loginTestWithDataProvider(String execute, String username, String password, String firstname, String lastname, String result){
        Pages page = new Pages();

        if(execute.equalsIgnoreCase("y")){
            page.loginPage().login(username, password);
            String actualFullName = page.dashboardPage().getUsersFullName();
            String expectedFullName = firstname+" "+lastname;
            Assert.assertEquals(actualFullName, expectedFullName, "Name doesn't match");
            page.dashboardPage().logout();
        }else{
            throw new SkipException("Test ignored");
        }
    }
    @DataProvider(name="credentials_info")
    public Object[][] credentials(){
        ExcelUtil qa2 = new ExcelUtil("src/test/resources/Vytrack_testusers.xlsx", "QA1-short");
        return qa2.getDataArray();
    }
}