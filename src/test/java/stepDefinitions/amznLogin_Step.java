package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmznLoginPage;
import utilities.Browser_Util;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.assertEquals;


public class amznLogin_Step {
    AmznLoginPage amznLoginPage = new AmznLoginPage();

    @Given("user navigates to the Amazon webpage")

    public void user_navigates_to_the_amazon_webpage() {
        Driver.getDriver().get(ConfigReader.read("amazonUrl"));
    }

    @When("user click on the sign in button")
    public void user_click_on_the_sign_in_button() {
        amznLoginPage.signInBtn_forEnteringCredential.click();
    }

    @When("user provide correct username {string} and password {string}")
    public void user_provide_correct_username_and_password(String userName, String password) {
        amznLoginPage.signIn(userName, password);
        Browser_Util.waitFor(3);
    }

    @Then("verify user logged in successfully {string}")
    public void verify_user_logged_in_successfully(String expected) {
        assertEquals(expected+"sad", amznLoginPage.loginVerification.getText());

    }

}
