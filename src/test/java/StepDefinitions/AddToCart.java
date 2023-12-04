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
<<<<<<< HEAD
        productCategoryPage = new ProductCategoryPage(driver);
=======
        productDisplayPage = new ProductDisplayPage(driver);
>>>>>>> 250c9764f758c0bb032ac01f58741cd56330a463

        productCategoryPage.clickOnAddToCartButton();

    }

    @And("selects a delivery date from delivery date field")
    public void selects_A_Delivery_Date_From_Delivery_Date_Field() {
<<<<<<< HEAD
       productDisplayPage = new ProductDisplayPage(driver);
=======
>>>>>>> 250c9764f758c0bb032ac01f58741cd56330a463
        productDisplayPage.typeCalendarDate();

    }

    @And("enters quantity in quantity field {}")
    public void enters_Quantity_In_Quantity_Field(String quantity) {
        productDisplayPage.enterQuantity(quantity);

    }


    @Then("success message indicating product added should be displayed")
    public void success_Message_Indicating_Product_Added_Should_Be_Displayed() {
<<<<<<< HEAD
        assertTrue(productDisplayPage.verifySuccessMessage().contains("Success"));
=======
        assertEquals(productDisplayPage.verifySuccessMessage()
                , "Success: You have added HP LP3065 to your shopping cart!");
>>>>>>> 250c9764f758c0bb032ac01f58741cd56330a463
    }

    @And("clicks on Add to cart button\\(Product display page)")
    public void clicks_On_Add_To_Cart_Button_Product_Display_Page() {
        productDisplayPage.clickOnAddToCartButtonProductDisplayPage();

    }
}
