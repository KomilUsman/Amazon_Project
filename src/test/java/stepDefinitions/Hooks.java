package stepDefinitions;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Browser_Util;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUpDriver(){
        System.out.println("This is from @Before inside Hook class");
        // set up implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Browser_Util.waitFor(3);
    }



    @After
    public void tearDown(Scenario scenario){
        System.out.println("THIS IS FROM @After inside Hooks class");
        if(scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver() ;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            Browser_Util.waitFor(3);
            // this is the line to attach screenshot to scenario
            scenario.attach(screenshot,"image/png",scenario.getName());
        }

        Driver.closeBrowser();

    }
}
