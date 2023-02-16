package com.exelenter.class4;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;

/*
 Task: Add Employees using Data Provider Annotation
         1. Open the Chrome browser
         2. Go to https://exelentersdet.com/
         3. Login into the application
         4. Navigate to Add Employee Page
         5. Add a new employee by providing
             - First Name
             - Last Name
         6. Click Save Button to save employee
         7. Verify that employee is added
         8. Close the browser
 */
public class _05_AddEmployee extends BaseClass {
    @Test(dataProvider = "testOne")
    public void addEmployeeTest(String firstName, String lastName) {
        loginPage.loginToWebsite("username", "password");
        wait(1);
        pimPage.navigateToAddEmployee();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.lastName, lastName);
        String expectedEmployeeId = addEmployeePage.employeeId.getAttribute("value");  // addEmployeePage
        clickButWaitForClickability(addEmployeePage.saveBtn);


        // Validate
        waitForVisibility(personalDetailsPage.personalDetailsHeader);
        String actualEmployeeId = personalDetailsPage.employeeId.getAttribute("value");
        Assert.assertEquals(actualEmployeeId, expectedEmployeeId, "Employee ID does not match");

    }

    @DataProvider(name = "testOne")         // When calling DataProvider in your @Test we can either use name of the method OR alias name.

    public Object[][] addEmployeesMethod() {
        Object[][] employee = {
                {"John", "Doe"},
                {"Jack", "Sparrow"}
        };


        return employee;
    }

    ;


}
