package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonSignIn {

    public AmazonSignIn() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='nav-action-inner' and text()='Sign in']")
    public WebElement signIn;

    @FindBy(xpath = "//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")
    public WebElement sendEmail;

    @FindBy(xpath = "//input [@class='a-button-input']")
    public WebElement continueBtn;

    @FindBy(xpath = "//h4[@class='a-alert-heading']")
    public WebElement errorText;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement howerOverEle;



}

