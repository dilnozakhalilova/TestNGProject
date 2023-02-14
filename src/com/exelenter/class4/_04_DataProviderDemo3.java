package com.exelenter.class4;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigsReader;

public class _04_DataProviderDemo3 extends BaseClass {

    // Instead of repeating ourselves with many test methods (login1, login2,login3,etc) instead we can use DataProvider

    @Test

    public void loginTest(){
        sendText(loginPage.username, ConfigsReader.getProperties("username"));
        sendText(loginPage.password, ConfigsReader.getProperties("password"));
        clickButWaitForClickability(loginPage.loginBtn);

        boolean welcomeDisplayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(welcomeDisplayed, "Welcome message is not displayed");
    }

    public void loginTest2(){
        sendText(loginPage.username, ConfigsReader.getProperties("username123"));
        sendText(loginPage.password, ConfigsReader.getProperties("password"));
        clickButWaitForClickability(loginPage.loginBtn);

        boolean welcomeDisplayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(welcomeDisplayed, "Welcome message is not displayed");
    }

    public void loginTest3(){
        sendText(loginPage.username, ConfigsReader.getProperties("username"));
       // sendText(loginPage.password, ConfigsReader.getProperties("password"));
        clickButWaitForClickability(loginPage.loginBtn);

        boolean welcomeDisplayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(welcomeDisplayed, "Welcome message is not displayed");
    }















}
