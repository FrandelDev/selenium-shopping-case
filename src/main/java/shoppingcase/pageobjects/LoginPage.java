package shoppingcase.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = ".customradio:nth-child(2)")
    WebElement userRadio;

    @FindBy(id = "terms")
    WebElement terms;

    @FindBy(id = "signInBtn")
    WebElement signInButton;

    @FindBy(css = ".form-control[data-style='btn-info']")
    WebElement select;

    @FindBy(xpath = "//div[@class='form-group']/p/b/i[contains(text(),'ra')]")
    WebElement username;

    @FindBy(xpath = "//div[@class='form-group']/p/b/i[contains(text(),'le')]")
    WebElement password;

    @FindBy(css = "div.alert-danger")
    WebElement incorretCredentialsMsg;

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getUserRadio() {
        return userRadio;
    }

    public WebElement getTerms() {
        return terms;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSelect() {
        return select;
    }

    public WebElement getIncorretCredentialsMsg() {
        return incorretCredentialsMsg;
    }

    
    
}
