package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddEmployeePage;
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
        var loginPage = new LoginPage();
        loginPage.loginToWebsite(ConfigsReader.getProperties("username"), ConfigsReader.getProperties("password"));

        var pimPage = new PIMPage();
        pimPage.navigateToAddEmployee();

        var addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, ConfigsReader.getProperties("empFirstName"));
        sendText(addEmployeePage.lastName, ConfigsReader.getProperties("emplLastName"));
        sendText(addEmployeePage.uploadPhoto, ConfigsReader.getProperties("filePath"));  // Retrieving photo location for uploading
        clickButWaitForClickability(addEmployeePage.saveBtn);


    }

}
