package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.EbayCars_AndTruck;
import utilities.Browser_Util;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.assertTrue;

public class CreateAccountEba_Step {
    EbayCars_AndTruck ebayCars_andTruck = new EbayCars_AndTruck();

    @Given("user on the cars and truck page")
    public void user_on_the_cars_and_truck_page() {
        Driver.getDriver().get(ConfigReader.read("ebayCarsAndTruck"));
    }

    @Given("on the filter section we need to fill the information")
    public void on_the_filter_section_we_need_to_fill_the_information() {

        ebayCars_andTruck.chooseDropDrown("BMW", "528i xDrive", "Used", "12101");
        Browser_Util.waitFor(5);

    }

    @Given("click Find Vehicle button")
    public void click_find_vehicle_button() {
        ebayCars_andTruck.findVehicleBtn.click();
    }

    @Then("verify page Title contains BMW")
    public void verify_page_title_contains_bmw() {

        assertTrue(Driver.getDriver().getTitle().contains("bmw"));
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());

    }


}
