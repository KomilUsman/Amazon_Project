package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import java.util.List;

public class EbayCars_AndTruck {

    public EbayCars_AndTruck() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='select motors-finder-menu']/select")
    public List<WebElement> dropDownLst;

    @FindBy(xpath = "//input[@class='textbox__control']")
    public WebElement zipCodeDropDown;

    @FindBy(id = "s0-27_1-9-0-1[0]-0-1-2-14[0[0]]")
    public WebElement findVehicleBtn;

    public void chooseDropDrown(String make, String model, String newOld, String ziCode) {

        Select selectMakes = new Select(dropDownLst.get(0));
        Select selectModels = new Select(dropDownLst.get(1));
        Select selectNewOld = new Select(dropDownLst.get(2));
        selectMakes.selectByValue(make);
        selectModels.selectByValue(model);
        selectNewOld.selectByVisibleText(newOld);

        Actions a = new Actions(Driver.getDriver());

        a.click(zipCodeDropDown).pause(2000).keyDown(Keys.CONTROL).
                sendKeys("A").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE).pause(2000).sendKeys(Keys.UP).sendKeys(ziCode)
                .perform();



    }
}

