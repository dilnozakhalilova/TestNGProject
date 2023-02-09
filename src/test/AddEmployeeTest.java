package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;

public class AddEmployeeTest extends BaseClass {
    @BeforeMethod
    void openBrowser() {
        setUp();

    }

    @AfterMethod
    void quitBrowser() {
        tearDown();
    }











}
