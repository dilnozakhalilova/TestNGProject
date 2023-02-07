package test;


import pages.LoginPageWithoutPageFactory;
import utils.BaseClass;

public class Logotest_Task extends BaseClass {

    /**
     * Task: Exelenter Project Logo Validation
     * 1. Navigate to URL https://www.exelentersdet.com/
     * 2. Verify Logo is displayed (No need to login)
     * 3. Quit the browser.
     * <p>
     * You can use LoginPage for storing logo's web element and create a
     * new LogoTest class for testing.
     */
    public static void main(String[] args) {
        setUp();

//        // With PageFactory
//        var logo = new _02_LoginPageWithPageFactory();
//        boolean isDisplayed = false;
//        if (logo.logo.isDisplayed()) {
//            System.out.println("Logo is Displayed");
//        } else {
//            System.out.println("Logo is not present");
//        }


        // Without PageFactory
        var loginPage = new LoginPageWithoutPageFactory();
        boolean logoDisplayed = loginPage.logo.isDisplayed();
        if ((logoDisplayed))
            System.out.println("logo is Displayed");
        else
            System.out.println("Logo is not displayed");






        tearDown();
    }


}