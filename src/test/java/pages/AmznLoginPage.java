package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmznLoginPage {

    public AmznLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement signInBtn_forEnteringCredential;

    @FindBy(xpath = "//input [@type='email']")
    public WebElement userName_inputBox;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//input[@id='ap_password']")
    public WebElement password_inputBox;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    public WebElement signInBtnForLogin;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement loginVerification;

    public void signIn(String userName, String password) {

        userName_inputBox.sendKeys(userName);
        continueBtn.click();
        password_inputBox.sendKeys(password);
        signInBtnForLogin.click();

    }


}
