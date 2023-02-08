package test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

/**
 * User stories
 * US 16457: As an Admin user I should be able to login to the admin page using valid login credentials.
 * US 23869: As a User, I should be able to login to the dashbaord page using valid login credentials.
 * US 83764: As a Business User, here goes your request...
 */

public class LoginTest extends BaseClass {

    @BeforeMethod
    void startBrowser(){
        setUp();
    }

    @AfterMethod
    void quitBrowser(){
        tearDown();
    }
    @Test
    public void validAdminLogin() {
        var login = new LoginPage();                                            // Happy path
        sendText(login.username, ConfigsReader.getProperties("username"));  // Valid username
        sendText(login.password, ConfigsReader.getProperties("password"));  // Valid Password
        clickButWaitForClickability(login.loginBtn);

        var dashboard = new DashboardPage();
        String expectedText = "Welcome Admin";
        String actualText = dashboard.welcome.getText();
        Assert.assertEquals(expectedText, actualText, "'Welcome Admin' text is incorrect");

    }

    @Test
    public void validUserInvalidPassword() {
        String invalidPassword = "Pass1234";
        String expectedErrorMessage = "Invalid credentials";
        LoginPage loginPage = new LoginPage();                                        // Negative testing
        sendText(loginPage.username, ConfigsReader.getProperties("username"));    // Valid username
        sendText(loginPage.password, invalidPassword);                                // Invalid password
        clickButWaitForClickability(loginPage.loginBtn);
        Assert.assertEquals(loginPage.loginErrorMessage, expectedErrorMessage, "Error message is incorrect. Test failed.");
    }

    @Test
    public void validUserAnEmptyPassword() {
        String expectedErrorMessage ="Password cannot be empty";
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.username, ConfigsReader.getProperties("username"));   // Valid username, Password empty(skipped)
        clickButWaitForClickability(loginPage.loginBtn);
        Assert.assertEquals(loginPage.loginErrorMessage,expectedErrorMessage,"Error message is incorrect. Test failed.");
    }


}
