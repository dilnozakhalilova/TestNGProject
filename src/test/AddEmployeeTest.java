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
        initialize();

    }

    @AfterMethod
    void quitBrowser() {
        tearDown();
    }


    @Test
    void addEmployeeTest() {
        //var loginPage = new LoginPage();    // now using PageInitializer in  utils
        loginPage.loginToWebsite(ConfigsReader.getProperties("username"), ConfigsReader.getProperties("password"));

        //var pimPage = new PIMPage(); // now using PageInitializer in  utils
        pimPage.navigateToAddEmployee();

        //var addEmployeePage = new AddEmployeePage(); // now using PageInitializer in  utils
        System.out.println("New employee ID: " + addEmployeePage.employeeId.getAttribute("value"));
        addEmployeePage.addEmployee(ConfigsReader.getProperties("empFirstName"),ConfigsReader.getProperties("empLastName"),ConfigsReader.getProperties("filePath")); // This method will add a new employee


    }

}
