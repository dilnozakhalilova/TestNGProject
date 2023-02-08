package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

/*
/*
 *  Task: Hard Assert & Soft Assertion
 *    First use Hard Assert
 *        1. Go to exelentersdet.com website
 *        2. Get the title of the webpage, change it to false, fail this test step intentionally
 *        3. Login to the website. You should NOT be able to login
 *    Now, comment out Hard Assert, and use Soft Assert instead.
 *        4. Using Soft Assert, try to login to the website.
 *    You should be able to login, even if the title verification (previous step) fails.
 */
public class _06_Task2 extends BaseClass {

    @BeforeMethod
    void openBrowser() {
        setUp();
    }

    @AfterMethod
    void closeBrowser() {
        tearDown();
    }

    @Test
    void loginAndVerify() {

        String websiteTitle = driver.getTitle();
        boolean websiteTitleEmpty = websiteTitle.isEmpty();

        Assert.assertTrue(websiteTitleEmpty,"Your website has a tile and is Not empty");

        LoginPage loginPage = new LoginPage();
        sendText(loginPage.username, ConfigsReader.getProperties("username"));
        sendText(loginPage.password, ConfigsReader.getProperties("password"));
        clickButWaitForClickability(loginPage.loginBtn);



    }


}
