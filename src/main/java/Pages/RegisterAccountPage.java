package Pages;

import Utilities.CommonUtils;
import Utilities.MyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {
    WebDriver driver ;
    CommonUtils utils ;
    public RegisterAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utils = new CommonUtils(driver);
    }
    @FindBy(id="input-firstname")
    private WebElement firstNameField;
    @FindBy(id = "input-lastname")
    private WebElement lastNameField;
    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id="input-telephone")
    private WebElement telephoneField;
    @FindBy(id="input-password")
    private WebElement passwordField;
    @FindBy(id="input-confirm")
    private WebElement passwordConfirmField;
    @FindBy(name="agree")
    private WebElement privacyPolicyButton;
    @FindBy(xpath="//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath="//input[@name='newsletter'][@value='1']")
    private WebElement yesNewsLetterField;
    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement privacyPolicyWarningMessage;
    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNameWaningMessage;
    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNameWarningMessage;
    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement emailWarningMessage;
    @FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneWarningMessage;

    @FindBy(xpath = "//input[@id=\'input-password\']/following-sibling::div")
    private WebElement passwordWarningMessage;
    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement duplicateEmailWarningMessage;



    public void enterFirstName(String firstName){
        utils.typeTextIntoElement(firstNameField, firstName, MyUtils.Explicit_Wait_Time);
       // firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        utils.typeTextIntoElement(lastNameField, lastName, MyUtils.Explicit_Wait_Time);
       // lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email){
        utils.typeTextIntoElement(emailField,email,MyUtils.Explicit_Wait_Time);
        //emailField.sendKeys(email);
    }

    public void enterTelephone(String telephone){
        utils.typeTextIntoElement(telephoneField,telephone,MyUtils.Explicit_Wait_Time);
       // telephoneField.sendKeys(telephone);
    }

    public void enterPassword(String password){
        utils.typeTextIntoElement(passwordField,password,MyUtils.Explicit_Wait_Time);
       // passwordField.sendKeys(password);
    }

    public void enterPasswordConfirm(String password){
        utils.typeTextIntoElement(passwordConfirmField,password,MyUtils.Explicit_Wait_Time);
       // passwordConfirmField.sendKeys(password);
    }

    public void acceptPrivacyPolicy(){
        utils.clickOnElement(privacyPolicyButton,MyUtils.Explicit_Wait_Time);
       // privacyPolicyButton.click();
    }

    public void clicksOnContinueButton(){
        utils.clickOnElement(continueButton,MyUtils.Explicit_Wait_Time);
       // continueButton.click();

    }

    public void selectYesInNewsLetterField(){
        utils.clickOnElement(yesNewsLetterField,MyUtils.Explicit_Wait_Time);
       // yesNewsLetterField.click();
    }

    public String verifyPrivacyPolicyWarningMessage(){
        String text = utils.getText(privacyPolicyWarningMessage, MyUtils.Explicit_Wait_Time);
        return text;// im returning the text cos thats what im using in my assertion.
      //return   privacyPolicyWarningMessage.getText();
    }

    public String verifyFirstNameWarningMessage(){
       return  utils.getText(firstNameWaningMessage, MyUtils.Explicit_Wait_Time);
      // return firstNameWaningMessage.getText();

    }

    public String verifyLastNameWarningMessage(){
        return utils.getText(lastNameWarningMessage, MyUtils.Explicit_Wait_Time);
      // return  lastNameWarningMessage.getText();

    }

    public String verifyEmailWarningMessage(){
       return utils.getText(emailWarningMessage, MyUtils.Explicit_Wait_Time);
       // return emailWarningMessage.getText();
    }

    public String verifyTelephoneWarningMessage(){
        return  utils.getText(telephoneWarningMessage,MyUtils.Explicit_Wait_Time);
       // return telephoneWarningMessage.getText();
    }

    public String verifyPasswordWarningMessage(){
        return  utils.getText(passwordWarningMessage, MyUtils.Explicit_Wait_Time);
        //return passwordWarningMessage.getText();
    }

    public boolean verifyDuplicateEmailWarningMessage(){
        return utils.isDisplayed(duplicateEmailWarningMessage,MyUtils.Explicit_Wait_Time);
     // return  duplicateEmailWarningMessage.isDisplayed();
    }

}
