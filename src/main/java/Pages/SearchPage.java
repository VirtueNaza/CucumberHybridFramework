package Pages;

import Utilities.CommonUtils;
import Utilities.MyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;
    CommonUtils utils ;
    public SearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utils = new CommonUtils(driver);
    }
    @FindBy(linkText = "Search")
    private WebElement searchBreadcrumb;
    @FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
    private WebElement NoMatchMessage;



    public boolean verifySearchBreadcrumb(){
        boolean text = utils.isDisplayed(searchBreadcrumb, MyUtils.Explicit_Wait_Time);
       // return searchBreadcrumb.isDisplayed();
        return text;
    }

    public String verifyNoMatchMessage(){
       return  utils.getText(NoMatchMessage, MyUtils.Explicit_Wait_Time);
        // return NoMatchMessage.getText();

    }
}
