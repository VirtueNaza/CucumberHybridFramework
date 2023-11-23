package Pages;

import Utilities.CommonUtils;
import Utilities.MyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    CommonUtils utils ;

    public HomePage(WebDriver driver){
        this.driver=driver;
        utils = new CommonUtils(driver);
        PageFactory.initElements(driver, this);

    }

@FindBy(xpath="//span[text()='My Account']")
    private WebElement myAccountButton;

    @FindBy(linkText="Login")
    private WebElement loginButton;
    @FindBy(linkText="Register")
    private WebElement registerButton;
    @FindBy(name ="search")
    private WebElement searchField;
    @FindBy(xpath = "//span[@class='input-group-btn']")
    private  WebElement searchIcon;

    @FindBy(xpath = "//a[text()='Laptops & Notebooks']")
    private WebElement dropDown;
    @FindBy(linkText = "Laptops & Notebooks")
    private WebElement laptopsSubHeaders;
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    private WebElement laptopsSubHeadersDropDown;




    public void ClickOnMyAccountButton(){
        utils.clickOnElement(myAccountButton, MyUtils.Explicit_Wait_Time);
       // myAccountButton.click();
    }

    public void clickOnLoginButton(){
        utils.clickOnElement(loginButton,MyUtils.Explicit_Wait_Time);
       // loginButton.click();

    }

    public void clickOnRegisterButton(){
        utils.clickOnElement(registerButton, MyUtils.Explicit_Wait_Time);
       // registerButton.click();

    }

    public void enterProductIntoSearchField(String product){
        utils.typeTextIntoElement(searchField,product,MyUtils.Explicit_Wait_Time);
       // searchField.sendKeys(product);
    }

    public void clickOnSearchIcon(){
        utils.clickOnElement(searchIcon, MyUtils.Explicit_Wait_Time);
        //searchIcon.click();
    }

    public String getTextLaptopsSubHeaders(){
        String text = utils.getText(laptopsSubHeadersDropDown, MyUtils.Explicit_Wait_Time);
        return text;
    }


    public void hoverOnLaptopsAndNotebooks(){
        utils.mouseHover(laptopsSubHeaders, MyUtils.Explicit_Wait_Time);
    }

    public void clickLaptopsSubHeadersDropDown(){
        utils.clickOnElement(laptopsSubHeadersDropDown, MyUtils.Explicit_Wait_Time);


    }

    public void clickOnLaptopSubHeaders(){
        dropDown.click();
    }


}
