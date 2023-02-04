package com.exelenter.class02;

import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class _01_ValidationTest extends BaseClass {


// We need to call WebDriver and also Quit it before and after Each Test.


    @BeforeMethod
    void openBrowser() {
        setUp();
    }

    @AfterMethod
    void afterMethod() {
        tearDown();
    }

    @Test
    void titleValidation() {
        String expectedTitle = "Exelenter Project";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle))
            System.out.println("Title does match. Test passed.");
        else
            System.out.println("Title does not match. Test failed.");
    }

    @Test
    void logoValidation() {
        var loginPage = new LoginPage();
        boolean logoDisplayed = loginPage.homepageLogo.isDisplayed();
        if (logoDisplayed)
            System.out.println("Logo is Displayed. Test passed");
        else
            System.out.println("Logo is not displayed. Test failed");
    }

    @Test
    void validLoginTest() {
        var loginPage = new LoginPage();
        // sendText(loginPage.username2,"Admin");    // Not recommended
        sendText(loginPage.username2, ConfigsReader.getProperties("username"));
        sendText(loginPage.password2, "Exelent2022Sdet!");
        sendText(loginPage.password2, ConfigsReader.getProperties("password"));
        click(loginPage.loginBtn2);

        var dashboard = new DashboardPage();
        String expectedValue = "Welcome Admin";
        String actualValue = dashboard.welcome.getText();
        if (expectedValue.equals(actualValue))
            System.out.println("Login successful");
        else System.out.println("Log in failed");


    }


}
