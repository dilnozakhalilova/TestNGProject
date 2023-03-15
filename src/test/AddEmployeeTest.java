package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigsReader;

public class AddEmployeeTest extends BaseClass {
    @Test
    void addEmployeeTest() {
        loginPage.loginToWebsite("username","password");
        pimPage.navigateToAddEmployee();
        System.out.println("New employee ID: " + addEmployeePage.employeeId.getAttribute("value"));
        addEmployeePage.addEmployee(ConfigsReader.getProperties("empFirstName"),ConfigsReader.getProperties("empLastName"),ConfigsReader.getProperties("filePath")); // This method will add a new employee


    }
    @ Test
    void print(){
        System.out.println("HiWorld");
    }

}
