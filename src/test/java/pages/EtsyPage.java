package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.ArrayList;
import java.util.List;
public class EtsyPage {

    public EtsyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='wt-btn wt-btn--transparent wt-btn--transparent-flush-left wt-btn--light wt-btn--icon wt-p-xs-1']")
    public List<WebElement> listOfIcons;

    //this method will scroll to element we want to scroll
    public void scrollToElement() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", listOfIcons.get(0));
    }

    //This method will switch to new tab by index
    public void moveTo(int indexNum) {
        ArrayList<String> newTab = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(newTab.get(indexNum));


    }
}
