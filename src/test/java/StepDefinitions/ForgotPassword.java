package StepDefinitions;

import Factory.DriverFactory;
import Pages.AccountForgottenPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;


public class ForgotPassword {
        WebDriver driver;
        LoginPage loginPage;
        HomePage homePage;
        AccountForgottenPage accountForgottenPage;

        @Given("user navigates to forgot password page")
        public void user_Navigates_To_Forgot_Password_Page() {

            driver = DriverFactory.getDriver();
            homePage= new HomePage(driver);
            homePage.ClickOnMyAccountButton();
            homePage.clickOnLoginButton();
            //once you click on login button, it will navigate to login page , so you can just create object of the login
            //button in the clickOnLogin button method created in "home page"
            loginPage = new LoginPage(driver);
            loginPage.clicksOnForgotPassword();

        }

        @When("user enters registered email into E-mail Address field {}")
        public void user_Enters_Registered_Email_Into_E_mail_Address_Field(String registeredEmail) {

            accountForgottenPage=new AccountForgottenPage(driver);
            accountForgottenPage.enterEmail(registeredEmail);

        }

        @And("clicks on continue button\\(Forgot Password page)")
        public void clicks_On_Continue_Button_Forgot_Password_Page() {
            accountForgottenPage.clickOnContinueButton();

        }

        @Then("success message indicating link sent to Email Address should be displayed")
        public void success_Message_Indicating_Link_Sent_To_Email_Address_Should_Be_Displayed() {
            homePage=new HomePage(driver);
            assertEquals("An email with a confirmation link has been sent your email address.",
                    loginPage.verifyWarningMessage());
        }

        @When("user enters unregistered email into E-mail Address field {}")
        public void user_Enters_Unregistered_Email_Into_EMail_Address_Field(String unRegisteredEmail) {
            accountForgottenPage=new AccountForgottenPage(driver);
            accountForgottenPage.enterEmail(unRegisteredEmail);
        }

        @Then("a warning message indicating E-mail not found should be displayed.")
        public void a_Warning_Message_Indicating_EMail_Not_Found_Should_Be_Displayed() {
            accountForgottenPage = new AccountForgottenPage(driver);
            assertEquals(accountForgottenPage.verifyWarningMessage(),
                    "Warning: The E-Mail Address was not found in our records, please try again!");

        }

        @When("user does not provide any details in E-mail Address field")
        public void user_Does_Not_Provide_Any_Details_In_EMail_Address_Field() {
            accountForgottenPage=new AccountForgottenPage(driver);


        }

        @When("user enters invalid email into E-mail Address field{}")
        public void user_Enters_Invalid_Email_Into_EMail_Address_Field(String invalidEmail) {
            accountForgottenPage=new AccountForgottenPage(driver);
            accountForgottenPage.enterEmail(invalidEmail);

        }


}


