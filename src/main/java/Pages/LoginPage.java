package Pages;

import Utilities.CommonUtils;
import Utilities.MyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver ;
    CommonUtils utils ;

    public LoginPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
        utils = new CommonUtils(driver);
    }
    @FindBy(id="input-email")
    private WebElement emailField;
    @FindBy(id="input-password")
    private WebElement passwordField;
    @FindBy(xpath="//input[@value='Login']")
    private WebElement loginButton;
    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
    private WebElement warningMessage;
    @FindBy(linkText = "Forgotten Password")
    private WebElement forgotPassword;
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement successMessage;








    public void entersEmailAddress(String email){
        utils.typeTextIntoElement(emailField,email, MyUtils.Explicit_Wait_Time);

    }

    public void entersPassword(String password){
        utils.typeTextIntoElement(passwordField,password,MyUtils.Explicit_Wait_Time);

    }

    public void clicksLoginButton(){
        utils.clickOnElement(loginButton,MyUtils.Explicit_Wait_Time);

    }

    public String verifyWarningMessage(){
        String text = utils.getText(warningMessage, MyUtils.Explicit_Wait_Time);
        return  text;

    }

    public void clicksOnForgotPassword(){
        utils.clickOnElement(forgotPassword,MyUtils.Explicit_Wait_Time);


    }

    public String verifySuccessMessage(){
        String text = utils.getText(successMessage, MyUtils.Explicit_Wait_Time);
     return  text;
    }
}
