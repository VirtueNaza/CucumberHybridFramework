package StepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;


public class search {

    WebDriver driver;
    HomePage homePage;

    @Given("user has opened application url")
    public void userHasOpenedApplicationUrl() {
        driver = DriverFactory.getDriver();// getting already initialized driver reference
      homePage = new HomePage(driver);
        assertEquals("Your Store", driver.getTitle());

    }
    @When("user enters valid product {string} into search field")
    public void user_Enters_Valid_Product_Into_Search_Field(String validProduct) {

        //driver.findElement(By.name("search")).sendKeys(validProduct);
        homePage.enterProductIntoSearchField(validProduct);

    }

    @And("clicks on search icon")
    public void clicks_On_Search_Icon() {

        //driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();
        homePage.clickOnSearchIcon();
        //.findElement(By.xpath("//div[@id='search']//button[@type='button']")).click();
    }

    @Then("user should be navigated to search  results page and valid product options should be displayed")
    public void user_Should_Be_Navigated_To_Search_Results_Page_And_Valid_Product_Options_Should_Be_Displayed() {
        //assertTrue(driver.findElement(By.linkText("Search")).isDisplayed());
        SearchPage searchPage = new SearchPage(driver);
        assertTrue(searchPage.verifySearchBreadcrumb());

    }

    @When("user enters non-existent product into search field {string}")
    public void user_Enters_Non_Existent_Product_Into_Search_Field(String nonExistentProduct) {

       // driver.findElement(By.name("search")).sendKeys(nonExistentProduct);
        homePage.enterProductIntoSearchField(nonExistentProduct);

    }

    @Then("proper message should be displayed indicating no product matching search")
    public void proper_Message_Should_Be_Displayed_Indicating_No_Product_Matching_Search() {

        SearchPage searchPage = new SearchPage(driver);
/*
        assertEquals("There is no product that matches the search criteria.",
                driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());*/

        assertEquals("There is no product that matches the search criteria.",
               searchPage.verifyNoMatchMessage());


    }

    @When("user does not provide any product in search field")
    public void userDoesNotProvideAnyProductInSearchField() {

        //intentionally leaving this empty
    }


}

