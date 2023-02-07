package com.exelenter.class02;

import org.bouncycastle.jcajce.provider.symmetric.ARC4;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseClass;

public class _03_TitleAndLogoValidation extends BaseClass {
    @BeforeMethod
    void openBrowser() {
        setUp();

    }

    @AfterMethod
    void quitBrowser() {
        tearDown();
    }

@Test
    void titleValidation(){
    String expectedTitle = "Exelenter Project";
    Assert.assertEquals(expectedTitle,driver.getTitle(),"Title is not verified");
}

    @Test(dependsOnMethods = "titleValidation")
    void logoValidation(){
        var loginPage = new LoginPage();
        boolean actualLogoDisplayed = loginPage.homepageLogo.isDisplayed();
        Assert.assertTrue(actualLogoDisplayed, "Logo is not Displayed");


}
// Note: if a test assertion fails, test will continue and quit the browser, because assert has a built-in Try Catch.




}
