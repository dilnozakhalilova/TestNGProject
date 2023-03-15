package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

public class PersonalDetailsPage extends BaseClass {
    @FindBy(id="personal_txtEmployeeId")
    public WebElement employeeId;

    @FindBy(css ="#pdMainContainer h1")
    public WebElement personalDetailsHeader;

    @FindBy(xpath = "//div[@id='profile-pic']/h1")
    public WebElement employeeFullName;


    public PersonalDetailsPage(){
        PageFactory.initElements(driver,this);
    }


}
