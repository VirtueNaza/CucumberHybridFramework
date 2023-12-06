package Pages;

import Utilities.CommonUtils;
import Utilities.MyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoryPage {
    WebDriver driver;
    CommonUtils utils ;

    public ProductCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new CommonUtils(driver);

    }

    @FindBy(xpath = "(//span[text()='Add to Cart'])[1]")
    private WebElement addToCart;




    public void  clickOnAddToCartButton() {
        utils.clickOnElement(addToCart, MyUtils.Explicit_Wait_Time);
       // return new ProductDisplayPage(driver);
       // addToCart.click();


    }
}