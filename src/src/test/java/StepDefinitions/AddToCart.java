package StepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import Pages.ProductCategoryPage;
import Pages.ProductDisplayPage;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AddToCart {

    /*This git stuff has stressed the life out of me literally*/

    WebDriver driver;
    ProductCategoryPage productCategoryPage;
    ProductDisplayPage productDisplayPage;

    @Given("^user navigates to product category page$")
    public void user_Navigates_To_Product_Category_Page() {

        driver = DriverFactory.getDriver();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnLaptopSubHeaders();
        //homePage.hoverOnLaptopsAndNotebooks();
        homePage.clickLaptopsSubHeadersDropDown();

    }

    @When("user clicks on Add To Cart button\\(Product category page)")
    public void user_Clicks_On_Add_To_Cart_Button_Product_Category_Page() {
        productCategoryPage = new ProductCategoryPage(driver);

        productCategoryPage.clickOnAddToCartButton();

    }

    @And("selects a delivery date from delivery date field")
    public void selects_A_Delivery_Date_From_Delivery_Date_Field() {
       productDisplayPage = new ProductDisplayPage(driver);
        productDisplayPage.typeCalendarDate();

    }

    @And("enters quantity in quantity field {}")
    public void enters_Quantity_In_Quantity_Field(String quantity) {
        productDisplayPage.enterQuantity(quantity);

    }


    @Then("success message indicating product added should be displayed")
    public void success_Message_Indicating_Product_Added_Should_Be_Displayed() {
        assertTrue(productDisplayPage.verifySuccessMessage().contains("Success"));
    }

    @And("clicks on Add to cart button\\(Product display page)")
    public void clicks_On_Add_To_Cart_Button_Product_Display_Page() {
        productDisplayPage.clickOnAddToCartButtonProductDisplayPage();

    }
}
