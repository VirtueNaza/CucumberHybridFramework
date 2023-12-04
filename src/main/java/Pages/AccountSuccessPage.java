package Pages;

import Utilities.CommonUtils;
import Utilities.MyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
    WebDriver driver ;
    CommonUtils utils ;
    public AccountSuccessPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        utils = new CommonUtils(driver);
    }
@FindBy(xpath = "//div[@id='content']/h1")
private WebElement accountSuccessMessage;





    public String verifyAccountSuccessMessage(){
        String text = utils.getText(accountSuccessMessage, MyUtils.Explicit_Wait_Time);
       return text;
    }


}
