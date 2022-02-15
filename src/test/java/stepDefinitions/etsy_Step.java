package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EtsyPage;
import utilities.Browser_Util;
import utilities.Driver;
import java.util.Arrays;
import static org.junit.Assert.assertTrue;
public class etsy_Step {
    //listOf_ExpectedTitle contain expected texts
    String[] listOf_ExpectedTitle = {"Instagram", "Facebook", "Pinterest", "Twitter", "YouTube"};

    //listOf_ActualTitle to store arrays of String that contain actual texts
    String[] listOf_ActualTitle = new String[5];

    EtsyPage etsyPage = new EtsyPage();

    @Given("user navigates to Etsy.com webpage")
    public void user_navigates_to_etsy_com_webpage() {
      //Navigating to https://www.etsy.com
        Driver.getDriver().get("https://www.etsy.com");
        Browser_Util.waitFor(1);
    }

    @When("user scrolls down element on the down of the webpage")
    public void user_scrolls_down_element_on_the_down_of_the_webpage() {
       // scrollToElement(); it will scroll to element we want to click
        etsyPage.scrollToElement();
        Browser_Util.waitFor(1);
    }

    @When("user clicks each elements to open new window")
    public void user_clicks_each_elements_to_open_new_window() {
       //count variable we can use to move to another tab by index
        int count = 5;

        //to click list of icons (instagram,facebook..etc)
        for (int i = 0; i < etsyPage.listOfIcons.size(); i++) {
            etsyPage.listOfIcons.get(i).click();

        }
        for (int i = 0; i < listOf_ActualTitle.length; i++) {
          //by using moveTo method and providing count(index) we are switching open windows tab
            etsyPage.moveTo(count);
            Browser_Util.waitFor(2);
            //Storing the title of all the open tabs to String Arrays
            listOf_ActualTitle[i] = Driver.getDriver().getTitle();
            count--;
        }

    }

    @Then("user should able to switch windows and get title of each elements")
    public void user_should_able_to_switch_windows_and_get_title_of_each_elements() {
        //printing the Actual title
        System.out.println("listOf_ActualTitle[i] = " + Arrays.toString(listOf_ActualTitle));
        //Iterating thorough String Array (listOf_ActualTitle) and asserting it contains Expected texts

        for (int i = 0; i < listOf_ActualTitle.length; i++) {

            assertTrue(listOf_ActualTitle[i].contains(listOf_ExpectedTitle[i]));

        }
    }
}


