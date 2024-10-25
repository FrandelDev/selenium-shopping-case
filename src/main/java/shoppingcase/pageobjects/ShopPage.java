package shoppingcase.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {

    public ShopPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn btn-info']")
    List<WebElement> addToCartButtons;

    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkoutCartButton;

    @FindBy(css = "td .btn-danger")
    List<WebElement> removeItemButtons;

    @FindBy(css = "td .btn-success")
    WebElement checkoutButton;
    
    @FindBy(id = "country")
    WebElement findCountryTextInput;

    @FindBy(className = "suggestions")
    WebElement suggestions;

    @FindBy(css = "label[for='checkbox2']")
    WebElement terms;

    @FindBy(css = "input[value='Purchase']")
    WebElement purchaseButton;

    @FindBy(className = "alert-success")
    WebElement succesMessage;

    public List<WebElement> getAddToCartButtons() {
        return addToCartButtons;
    }

    public WebElement getCheckoutCartButton() {
        return checkoutCartButton;
    }

    public List<WebElement> getRemoveItemButtons() {
        return removeItemButtons;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public WebElement getFindCountryTextInput() {
        return findCountryTextInput;
    }

    public WebElement getSuggestions() {
        return suggestions;
    }

    public WebElement getTerms() {
        return terms;
    }

    public WebElement getPurchaseButton() {
        return purchaseButton;
    }

    public WebElement getSuccesMessage() {
        return succesMessage;
    }

    
    
}
