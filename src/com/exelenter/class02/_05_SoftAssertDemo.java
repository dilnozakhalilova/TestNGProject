package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class _05_SoftAssertDemo extends BaseClass {

    @BeforeMethod
    void openBrowser() {
        setUp();

    }

    @AfterMethod
    void quitBrowser() {
        tearDown();
    }

    @Test
    void softAssertionTest() {
        // First: Verify Logo is displayed
        LoginPage login = new LoginPage();
        boolean displayed = login.homepageLogo.isDisplayed();
        displayed=false;
        //Assert.assertTrue(displayed, "Homepage Logo is not displayed");  // Validating logo

        // Soft Assert( if soft Assert fails, remaining test steps will continue)
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(displayed, "Homepage Logo is not displayed");

        // Second: Login to the website

        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password, ConfigsReader.getProperties("password"));
        clickButWaitForClickability(login.loginBtn);
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertEquals(dashboardPage.welcome.getText(), "Welcome Admin", "'Welcome Admin' text is not correct");  // Validating logo

        System.out.println("Using Hard Assert if previous test assertion failed, this line will not print");

        // assertAll() method MUST be used at the end of soft-assert test. This will check ALL assertions, if one fails all test fails.
        // but if you forget it, if one passes, entire @Test passes

        softAssert.assertAll();
    }


}
