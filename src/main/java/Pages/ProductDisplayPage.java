package Pages;

import Utilities.CommonUtils;
import Utilities.MyUtils;
import Utilities.ProjectProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.Properties;

public class ProductDisplayPage {
    WebDriver driver;

    CommonUtils utils ;
    public ProductDisplayPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new CommonUtils(driver);

    }

    @FindBy(xpath = "//div[@class='form-group required']//span[@class='input-group-btn']")
    private WebElement calendarButton;

    @FindBy(id="input-option225")
    private WebElement calendarField;
    @FindBy(id="input-quantity")
    private  WebElement quantityField;

    @FindBy(id="button-cart")
    private  WebElement addtocartButton;

    @FindBy(xpath = "//div[contains(@class,'alert-success ')]")
    private WebElement successMessage;




    public void selectDateInCalender(String expectedMonth, int expectedYear) {


    }

    public void typeCalendarDate(){
        Properties prop = ProjectProperties.MyProperties();
        String date = prop.getProperty("Date");

        utils.typeTextIntoElement(calendarField,date, MyUtils.Explicit_Wait_Time);
    }

    public void enterQuantity(String quantity){
        utils.typeTextIntoElement(quantityField, quantity,MyUtils.Explicit_Wait_Time);
    }

    public void clickOnAddToCartButtonProductDisplayPage(){
        utils.clickOnElement(addtocartButton, MyUtils.Explicit_Wait_Time);
    }

    public String verifySuccessMessage(){
       return  utils.getText(successMessage, MyUtils.Explicit_Wait_Time);

    }

}
