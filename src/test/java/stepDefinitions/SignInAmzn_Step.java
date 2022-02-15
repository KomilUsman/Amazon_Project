package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.AmazonSignIn;
import utilities.Browser_Util;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.assertEquals;

public class SignInAmzn_Step {

    AmazonSignIn signInPage = new AmazonSignIn();

    @Given("user go to Amazon homepage")
    public void user_go_to_amazon_homepage() {
        Driver.getDriver().get(ConfigReader.read("amazonUrl"));
        Browser_Util.waitFor(3);
    }


    @When("Click Sign in button")
    public void click_sign_in_button() {

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(signInPage.howerOverEle).perform();
        Browser_Util.waitFor(3);
        signInPage.signIn.click();
        Browser_Util.waitFor(3);
    }

    @When("user send wrong credentials {string}")
    public void user_send_wrong_credentials(String userName) {
        signInPage.sendEmail.sendKeys(userName);

        signInPage.continueBtn.click();
        Browser_Util.waitFor(3);
    }

    @Then("user should be able to see error message")
    public void user_should_be_able_to_see_error_message() {
        assertEquals("There was a problem", signInPage.errorText.getText());
     //   System.out.println("signInPage.errorText.getText() = " + signInPage.errorText.getText());
    }

}
