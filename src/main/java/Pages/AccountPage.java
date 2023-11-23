package Pages;

import Utilities.CommonUtils;
import Utilities.MyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    WebDriver driver;
    CommonUtils utils ;
    public AccountPage(WebDriver driver ){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        utils = new CommonUtils(driver);
    }

@FindBy(linkText="My Account")
    private WebElement myAccountRightSideOption;








    public boolean verifyMyAccountRightSideOption(){
        boolean isDisplayed = utils.isDisplayed(myAccountRightSideOption, MyUtils.Explicit_Wait_Time);
        return  isDisplayed;

    }
}
