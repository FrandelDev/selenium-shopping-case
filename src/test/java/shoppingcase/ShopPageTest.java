package shoppingcase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import shoppingcase.pageobjects.ShopPage;

public class ShopPageTest {
    WebDriver driver;
    WebDriverWait driverWait;
    BaseConfig config;
    ShopPage shopPage;

    @BeforeClass
    public void setUp() {
        config = BaseConfig.getInstance();
        driver = BaseConfig.getDriverInstance();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        shopPage = new ShopPage(driver);
        // driver.get("https://rahulshettyacademy.com/angularpractice/shop");
    }

    @Test(priority = 1)
    public void can_add_each_item_to_cart() {
        List<WebElement> items = shopPage.getAddToCartButtons();
        WebElement goToCartButton = shopPage.getCheckoutCartButton();

        items.forEach((element) -> {
            element.click();
        });

        Integer quantity = Integer.valueOf(goToCartButton.getText().charAt(12));
        Assert.assertTrue(quantity > 0);
    }

    @Test(priority = 2)
    public void can_remove_items() {
        shopPage.getCheckoutCartButton().click();
        List<WebElement> removeItemButtons = shopPage.getRemoveItemButtons();
        WebElement itemToRemove = removeItemButtons.get(2);
        driverWait.until(ExpectedConditions.elementToBeClickable(itemToRemove));
        Integer sizeBeforeElimination = removeItemButtons.size();
        itemToRemove.click();
        Assert.assertTrue(sizeBeforeElimination > removeItemButtons.size());
    }

    @Test(priority = 3)
    public void can_purchase() {
        shopPage.getCheckoutButton().click();
        shopPage.getFindCountryTextInput().sendKeys("A");
        WebElement suggestions = shopPage.getSuggestions();
        driverWait.until(ExpectedConditions.visibilityOfAllElements(suggestions));
        suggestions.findElement(By.linkText("Andorra")).click();
        shopPage.getTerms().click();
        shopPage.getPurchaseButton().click();
        Assert.assertTrue(shopPage.getSuccesMessage().isDisplayed());
    }
}
