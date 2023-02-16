package com.exelenter.class05;

import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigsReader;

/*
 Task: HW: Add Employees using Data Provider Annotation
         1.  Open the Chrome browser
         2.  Go to https://exelentersdet.com/
         3.  Login into the application
         4.  Navigate to Add Employee Page
         5.  Add 5 different Employees and create login credentials by providing:
                 - First Name
                 - Last Name
                 - Username
                 - Password
         6.  Verify Employee has been added successfully and take screenshots (you
              must have 5 different screenshots)
         7.  Close the browser
              BONUS: Specify a group name for this test case, and execute from the
              XML file.
 */
public class _02_HW_AddEmployee extends BaseClass {
    @Test
    public void addEmployeeTest(String firstName, String lastName, String username, String password) {
        loginPage.loginToWebsite("username", "password");  // Log in to website
        wait(1);
        pimPage.navigateToAddEmployee();
        wait(1);
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.lastName, lastName);
        String expectedEmployeeId = addEmployeePage.employeeId.getAttribute("value");
        System.out.println("expectedEmployeeId:  " + expectedEmployeeId);
        jsClick(addEmployeePage.CreateLoginDetailsCheckbox); // in case an advertisement blocks it
        wait(1);
        sendText(addEmployeePage.userName, username);
        sendText(addEmployeePage.password, password);
        sendText(addEmployeePage.userName, password);
        System.out.println("username:  " + username);
        System.out.println("password:  " + password);
        wait(1);
        click(addEmployeePage.saveBtn);

    }

}
