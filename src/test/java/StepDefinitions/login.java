package StepDefinitions;

import Factory.DriverFactory;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;

public class login {
        WebDriver driver;
        HomePage homePage;
        LoginPage loginPage;

        @Given("^user navigates to login page$")
        public void user_Navigates_To_Login_Page() {

                driver = DriverFactory.getDriver();
                homePage= new HomePage(driver);
                //driver.findElement(By.xpath("//span[text()='My Account']")).click(); using page object model to avoid
                //hardcoding the constructors.
                homePage.ClickOnMyAccountButton();

               // driver.findElement(By.linkText("Login")).click();
                homePage.clickOnLoginButton();
        }

        @When("user enters valid email address {string} into email address field")
        public void user_Enters_Valid_Email_Address_Into_Email_Address_Field(String validEmail)  {

                //driver.findElement(By.id("input-email")).sendKeys(validEmail);
                 loginPage = new LoginPage(driver);
                loginPage.entersEmailAddress(validEmail);

        }

        @And("enters valid password {string} into password field")
        public void enters_Valid_Password_Into_Password_Field(String validPassword)  {

                //driver.findElement(By.id("input-password")).sendKeys(validPassword);
                loginPage.entersPassword(validPassword);

        }

        @And("^clicks on login button$")
        public void clicks_On_Login_Button() {

                //driver.findElement(By.xpath("//input[@value='Login']")).click();
                loginPage.clicksLoginButton();
        }

        @Then("^user should successfully log in and be navigated to account page$")
        public void user_Should_Successfully_LogIn_And_Be_Navigated_To_Account_Page() {

                AccountPage accountPage = new AccountPage(driver);

                assertTrue(accountPage.verifyMyAccountRightSideOption());
                   fail();// intentionally failing this test case
        }

        @When("user enters invalid email address {string} into email address field")
        public void user_Enters_Invalid_Email_Address_Into_Email_Address_Field(String invalidEmail)  {

               // driver.findElement(By.id("input-email")).sendKeys(invalidEmail);
                loginPage= new LoginPage(driver);
                loginPage.entersEmailAddress(invalidEmail);
        }

        @And("enters invalid password {string} into password field")
        public void enters_Invalid_Password_Into_Password_Field(String invalidPassword)  {

                //driver.findElement(By.id("input-password")).sendKeys(invalidPassword);
                loginPage.entersPassword(invalidPassword);
        }

        @Then("^user should get proper warning message indicating no match for email address or password$")
        public void user_Should_Get_Proper_Warning_Message_Indicating_No_Match_For_Email_Address() {
                /*assertEquals(
                        "Warning: No match for E-Mail Address and/or Password.",
                        driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText());*/
                assertEquals(
                        "Warning: No match for E-Mail Address and/or Password.",
                        loginPage.verifyWarningMessage());
        }

        @When("user does not provide any details")
        public void userDoesNotProvideAnyDetails() {
                loginPage= new LoginPage(driver);
        }
}


