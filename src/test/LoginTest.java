package test;


import pages.LoginPageWithoutPageFactory;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class LoginTest extends BaseClass {
    public static void main(String[] args) {
        setUp();

        // Note: Make sure to comment out one before using the other.

//        // Without PageFactory


        var loginPage = new LoginPageWithoutPageFactory();
//        sendText(loginPage.username, ConfigsReader.getProperties("username"));
//        sendText(loginPage.password, ConfigsReader.getProperties("password"));
//        clickButWaitForClickability(loginPage.loginBtn);


        // With PageFactory

        var login = new LoginPage();
        sendText(login.username2, ConfigsReader.getProperties("username"));
        sendText(login.password2, ConfigsReader.getProperties("password"));
        clickButWaitForClickability(login.loginBtn2);


        tearDown();
    }


}
