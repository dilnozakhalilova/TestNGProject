package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class AddEmployeeTest extends BaseClass {
    @BeforeMethod
    void openBrowser() {
        setUp();

    }

    @AfterMethod
    void quitBrowser() {
        tearDown();
    }


    @Test
    void addEmployeeTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToWebsite("username","password");

        PIMPage pimPage = new PIMPage();
        pimPage.navigateToAddEmployee();

    }

}
