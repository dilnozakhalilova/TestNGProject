package com.exelenter.class02;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

/**
 * TC 01: Login Validation Test (Happy Path)
 * 1. Open chrome browser
 * 2. Go to https://exelentersdet.com
 * 3. Enter valid username and valid password
 * 4. Click on login button
 * 5. Verify login is successful
 * 6. Close the browser
 * <p>
 * TC 02: Login Validation Test (Negative Test)
 * 1. Open Chrome browser
 * 2. Go to http://exelentersdet.com
 * 3. Enter valid username
 * 4. Leave password field empty
 * 5. Verify error message with text “Password cannot be empty” is displayed.
 */
public class _02_AssertDemo extends BaseClass {
    @BeforeMethod
    void openBrowser() {
        setUp();

    }

    @AfterMethod
    void quitBrowser() {
        tearDown();
    }

    @Test
    void validLoginTest() {
        // Log in to the application

        LoginPage login = new LoginPage();
        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password, ConfigsReader.getProperties("password"));
        clickButWaitForClickability(login.loginBtn);


        // Validation

        DashboardPage dashboard = new DashboardPage();
        String expectedText = "Welcome Admin";
        String actualText = dashboard.welcome.getText();

        Assert.assertEquals(expectedText,actualText,"'Welcome Admin' text is incorrect");

    }


}
