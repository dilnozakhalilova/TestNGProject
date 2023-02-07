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

public class _04_Task1 extends BaseClass {
    @BeforeMethod
    void openBrowser() {
        setUp();

    }

    @AfterMethod
    void quitBrowser() {
        tearDown();
    }

    @Test
    void dashboardLogoValidation() {
        var login = new LoginPage();
        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password, ConfigsReader.getProperties("password"));
        clickButWaitForClickability(login.loginBtn);

        var dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.dashboardLogo.isDisplayed(), "Logo is not displayed");

    }


}
