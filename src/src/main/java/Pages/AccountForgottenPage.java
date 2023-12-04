package Pages;

import Utilities.CommonUtils;
import Utilities.MyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountForgottenPage {
    WebDriver driver;
    CommonUtils utils;
    public AccountForgottenPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utils = new CommonUtils(driver);

    }
    @FindBy(id="input-email")
    private WebElement emailField;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement warningMessage;







    public void enterEmail(String email){
        utils.clickOnElement(emailField, MyUtils.Explicit_Wait_Time);

    }

    public void clickOnContinueButton(){
        utils.clickOnElement(continueButton,MyUtils.Explicit_Wait_Time);


    }
    public String verifyWarningMessage(){
        String text = utils.getText(warningMessage, MyUtils.Explicit_Wait_Time);
     return text;
    }

}
