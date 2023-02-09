package utils;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

import java.nio.channels.Pipe;

public class PageInitializer {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static PIMPage pimPage;
    public static AddEmployeePage addEmployeePage;


    public static void initialize() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        pimPage = new PIMPage();
        addEmployeePage = new AddEmployeePage();
    }
}
