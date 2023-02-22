package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;
import utils.ConfigsReader;

import static utils.BaseClass.driver;

// Note: This is just a template for LogInPage where we store everything related to log in page here, in this class
// In Page Object Model (POM) Design Patter we organize our code by pages. Each webpage will have its own class.
public class LoginPage extends BaseClass {


    // Log in with PageFactory

// @FindBy() == driver.findElement()

    @FindBy(id = "txtUsername")      // Locating by ID
    public WebElement username;

    @FindBy(name = "txtPassword")    // Locating by Name
    public WebElement password;

    @FindBy(xpath = "//input[@id='btnLogin']")           // Locating by xPath
    public WebElement loginBtn;

    @FindBy(id = "spanMessage")
    public WebElement loginErrorMessage;
    @FindBy(css = "#divLogo img")
    public WebElement homepageLogo;


    public LoginPage() {
        PageFactory.initElements(driver, this);   // this==> refering to clas name ==>_02_LoginPageWithPageFactory.class

    }

    public void loginToWebsite(String user, String pswd){
//        sendText(username, ConfigsReader.getProperties(user));
//        sendText(password,ConfigsReader.getProperties(pswd));
        sendText(username, ConfigsReader.getProperties(user));
        sendText(password,ConfigsReader.getProperties(pswd));
        clickButWaitForClickability(loginBtn);
    }
}
