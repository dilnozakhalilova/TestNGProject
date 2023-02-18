package com.exelenter.class05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ExcelUtility;

import static org.testng.Assert.*;

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
    @Test(dataProvider = "addEmployees")
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
        sendText(addEmployeePage.confirmPassword, password);
        System.out.println("username:  " + username);
        System.out.println("password:  " + password);
        wait(1);
        click(addEmployeePage.saveBtn);


        // Validation
//
//        waitForVisibility(personalDetailsPage.personalDetailsHeader);
//        String actualEmployeeId = personalDetailsPage.employeeId.getAttribute("value");
//        assertEquals(actualEmployeeId, expectedEmployeeId, "Test failed. Employee ID does not match");
//        takeScreenshot(firstName + "_" + lastName + ".png");
//        System.out.println("New employee successfully added");
//
//    }

        // 2nd Validation with Try-Catch
        try {
            boolean headerDisplayed = personalDetailsPage.personalDetailsHeader.isDisplayed();
            if (headerDisplayed) {
                String actualEmployeeId = personalDetailsPage.employeeId.getAttribute("value");
                assertEquals(actualEmployeeId, expectedEmployeeId, "Employee ID does not match");
                takeScreenshot(firstName + "_" + lastName);
                System.out.println("The new employee is added successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 1st way to fail your test
//            System.out.println("Employee is not added. Username or ID already exits.");
//            Assert.fail();
            // 2nd way to fail my test
            throw new RuntimeException("Employee is not added. Username or ID already exits.");
        }
    }

    @DataProvider
    public Object[][] addEmployees() {
        return new Object[][]{
                {"Sophie", "Patelina", "sophiepatelina123", randomStrongPassWord()},
                {"Maria", "Sharapova", "msharapova123", randomStrongPassWord()},
                {"Jaclyn", "Smith", "jsmith123", randomStrongPassWord()},
                {"Marry", "jackson", "mjackson", randomStrongPassWord()},
                {"Sam", "Zarn", "szarn123", randomStrongPassWord()}

        };

    }

    // 2nd Way How to read data from Excel

    @DataProvider
    public Object[][] getDataFromExcel() {
        // I will bring method from ExcelUtility, therefore my method return must match==Object[][]
        String absolutePath = ExcelUtility.projectPath + "testData/ExelenterEmployees.xlsx";
        return ExcelUtility.readFromExcel(absolutePath,"Employee");
    }


}
