package shoppingcase;

import java.security.SecureRandom;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import shoppingcase.pageobjects.LoginPage;

public class Utils {
    
    WebDriver driver;
    WebDriverWait driverWait;
    LoginPage loginPage;

    public Utils(WebDriver driver, LoginPage loginPage){
        this.driver = driver;
        this.loginPage = loginPage;
    }

    public void loginUser(String username, String password){
        WebElement usernameField = loginPage.getUsernameField();
        WebElement passwordField = loginPage.getPasswordField();
        WebElement radio = loginPage.getUserRadio();
        WebElement terms = loginPage.getTerms();
        WebElement signInButton = loginPage.getSignInButton();
        WebElement select = loginPage.getSelect();
        Select selectable = new Select(select);
        SecureRandom randomOption = new SecureRandom();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
       
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    
        radio.click();
    
      
    driverWait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
    driver.findElement(By.id("okayBtn")).click();
    
    selectable.selectByIndex(randomOption.nextInt(0, 3));

   if(!terms.isSelected()) terms.click();
   
    signInButton.click();

    
    }
}
