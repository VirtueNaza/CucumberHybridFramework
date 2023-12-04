package StepDefinitions;

import Factory.DriverFactory;
import Pages.AccountSuccessPage;
import Pages.HomePage;
import Pages.RegisterAccountPage;
import Utilities.MyUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class Register {

    WebDriver driver;
    RegisterAccountPage registerAccountPage;
    AccountSuccessPage accountSuccessPage;

    @Given("user navigates to register account page")
    public  void user_Navigates_To_Register_Account_Page() {
        driver = DriverFactory.getDriver();// to get the driver reference from the one I already initialized
       // driver.findElement(By.xpath("//span[text()='My Account']")).click();
        HomePage homePage = new HomePage(driver);
        homePage.ClickOnMyAccountButton();
       // driver.findElement(By.linkText("Register")).click();
        homePage.clickOnRegisterButton();
    }

    @When("user enters the following details:")
    public void user_Enters_The_Following_Details(DataTable dataTable) {

        Map<String, String> map = dataTable.asMap(String.class, String.class);


        registerAccountPage = new RegisterAccountPage(driver);

        //driver.findElement(By.id("input-firstname")).sendKeys(map.get("FirstName"));
        registerAccountPage.enterFirstName(map.get("FirstName"));
       // driver.findElement(By.id("input-lastname")).sendKeys(map.get("LastName"));
        registerAccountPage.enterLastName(map.get("LastName"));
        //driver.findElement(By.id("input-email")).sendKeys(MyUtils.generateEmail());
        registerAccountPage.enterEmail(MyUtils.generateEmail());
        //driver.findElement(By.id("input-telephone")).sendKeys(map.get("Telephone"));
        registerAccountPage.enterTelephone(map.get("Telephone"));
       // driver.findElement(By.id("input-password")).sendKeys(map.get("Password"));
        registerAccountPage.enterPassword(map.get("Password"));
        //driver.findElement(By.id("input-confirm")).sendKeys(map.get("Password"));
        registerAccountPage.enterPasswordConfirm(map.get("Password"));
    }

    @And("selects privacy policy")
    public void selects_Privacy_Policy() {

       // driver.findElement(By.name("agree")).click();
        registerAccountPage.acceptPrivacyPolicy();

    }

    @Then("account should be created and user navigated to account success page")
    public void account_Should_Be_Created_And_User_Navigated_To_Account_Success_Page() {

         accountSuccessPage = new AccountSuccessPage(driver);
        assertEquals("Your Account Has Been Created!",
           accountSuccessPage.verifyAccountSuccessMessage());

       /* assertEquals("Your Account Has Been Created!",
                driver.findElement(By.xpath("//div[@id='content']/h1")).getText());*/
    }

    @And("selects yes in Newsletter field")
    public void selects_Yes_In_Newsletter_Field() {

       // driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        registerAccountPage.selectYesInNewsLetterField();

    }

    @Then("user should get proper warning messages for all mandatory fields")
    public void user_Should_Get_Proper_Warning_Messages_For_All_Mandatory_Fields() {

     /* assertEquals("Warning: You must agree to the Privacy Policy!",
              driver.findElement(By.xpath("//div[contains(@class,' alert-dismissible')]")).getText());*/

        assertEquals("Warning: You must agree to the Privacy Policy!",
              registerAccountPage.verifyPrivacyPolicyWarningMessage());

      /*assertEquals("First Name must be between 1 and 32 characters!",
              driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());*/

        assertEquals("First Name must be between 1 and 32 characters!",
               registerAccountPage.verifyFirstNameWarningMessage());
     /* assertEquals("Last Name must be between 1 and 32 characters!",
              driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());*/
        assertEquals("Last Name must be between 1 and 32 characters!",
                registerAccountPage.verifyLastNameWarningMessage());
      /*assertEquals("E-Mail Address does not appear to be valid!",
              driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());*/
        assertEquals("E-Mail Address does not appear to be valid!",
                registerAccountPage.verifyEmailWarningMessage());
      /*assertEquals("Telephone must be between 3 and 32 characters!",
              driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());*/
        assertEquals("Telephone must be between 3 and 32 characters!",
                registerAccountPage.verifyTelephoneWarningMessage());
      /*assertEquals("Password must be between 4 and 20 characters!",
              driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());*/
        assertEquals("Password must be between 4 and 20 characters!",
                registerAccountPage.verifyPasswordWarningMessage());

    }

    @And("clicks on continue button")
    public void clicks_On_Continue_Button() {

        //driver.findElement(By.xpath("//input[@value='Continue']")).click();
        registerAccountPage.clicksOnContinueButton();
    }

    @Then("proper error message should be displayed indicating duplicate email address")
    public void proper_Error_Message_Should_Be_Displayed_Indicating_Duplicate_Email_Address() {

        assertTrue(registerAccountPage.verifyDuplicateEmailWarningMessage());

    }

    @When("user enters the following details with duplicate email:")
    public void user_Enters_The_Following_Details_With_Duplicate_Email(DataTable dataTable) {

        Map<String, String> map = dataTable.asMap(String.class, String.class);

        registerAccountPage= new RegisterAccountPage(driver);


        registerAccountPage.enterFirstName(map.get("FirstName"));

        registerAccountPage.enterLastName(map.get("LastName"));

        registerAccountPage.enterEmail(map.get("E-mail"));

        registerAccountPage.enterTelephone(map.get("Telephone"));

        registerAccountPage.enterPassword(map.get("Password"));

        registerAccountPage.enterPasswordConfirm(map.get("Password"));

       /* driver.findElement(By.id("input-firstname")).sendKeys(map.get("FirstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(map.get("LastName"));
        driver.findElement(By.id("input-email")).sendKeys(map.get("E-mail"));
        driver.findElement(By.id("input-telephone")).sendKeys(map.get("Telephone"));
        driver.findElement(By.id("input-password")).sendKeys(map.get("Password"));
        driver.findElement(By.id("input-confirm")).sendKeys(map.get("Password"));*/
    }



    @Then("proper warning message indicating select privacy policy should be displayed")
    public void proper_Warning_Message_Indicating_Select_Privacy_Policy_Should_Be_Displayed() {

        assertEquals("Warning: You must agree to the Privacy Policy!",
                registerAccountPage.verifyPrivacyPolicyWarningMessage());

    }

    @When("user does not provide any details into any field")
    public void userDoesNotProvideAnyDetailsIntoAnyField() {

        registerAccountPage= new RegisterAccountPage(driver);
    }
}

