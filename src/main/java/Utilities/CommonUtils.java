package Utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUtils {
    WebDriver driver;
    WebDriverWait wait;
    public CommonUtils(WebDriver driver){
        this.driver=driver;
       // PageFactory.initElements(driver,this);

    }

    public void clickOnElement(WebElement element, long waitingTime){

        WebElement webelement = waitToBeClickable(element, waitingTime);
        webelement.click();

    }

    public void typeTextIntoElement(WebElement element , String textToBeTyped ,long waitingTime){

        WebElement webElement = waitToBeClickable(element, waitingTime);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(textToBeTyped);

    }


    /*public void selectOptionInDropDown(WebElement element, String text, long waitingTime){
       WebElement webElement=  waitToBeClickable(element,waitingTime);

        Select select = new Select(webElement);
        select.selectByVisibleText(text);

    }*/

    public void acceptAlert(long waitingTime){

        Alert alert = waitForAlert(waitingTime);
        alert.accept();

    }

    public void dismissAlert(long waitingTime){
       Alert alert =  waitForAlert(waitingTime);
       alert.dismiss();

    }

    public void mouseHover(WebElement element, long waitingTime){
        WebElement webElement = waitToBeClickable(element, waitingTime);
        Actions actions= new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();

    }

    public void selectDropdownOption(WebElement element, String text, long waitingTime){
        Select select = new Select(element);
        select.selectByVisibleText(text);

    }

    public void javaScriptClick(){


    }
    public String getText(WebElement element, long waitingTime){
        WebElement webElement = waitForVisibilityOfElement(element, waitingTime);
        String text = webElement.getText();
        return text;

    }

    public boolean isDisplayed(WebElement element , long waitingTime){
        WebElement webElement = waitForVisibilityOfElement(element, waitingTime);
      return webElement.isDisplayed();

    }









public WebElement waitToBeClickable(WebElement element, long waitingTime) {
     wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
    WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
    return webElement;
}

public Alert waitForAlert(long waitingTime){
    wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    return alert;

}

public WebElement waitForVisibilityOfElement(WebElement element , long waitingTime){
        wait =new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
}





}
