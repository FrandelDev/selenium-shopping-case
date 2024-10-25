package shoppingcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import shoppingcase.pageobjects.LoginPage;

public class LoginPageTest {

    WebDriver driver;
    WebDriverWait driverWait;
    BaseConfig config;
    LoginPage loginPage;
    Utils utils;

    @BeforeSuite
    public void setUp() {
        config = BaseConfig.getInstance();
        driver = BaseConfig.getDriverInstance();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        utils = new Utils(driver,loginPage);
        config.initialize();
    }


    @Test(priority = 1)
    public void can_not_do_login(){
        WebElement errorMessage = loginPage.getIncorretCredentialsMsg();
        utils.loginUser("not an user", "not a password");
        driverWait.until(ExpectedConditions.visibilityOf(errorMessage));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test(priority = 2)
    public void can_do_login() throws InterruptedException {
        driver.findElement(By.cssSelector(".customradio:nth-child(1)")).click();
        Thread.sleep(2000);
        utils.loginUser(loginPage.getUsername().getText(), loginPage.getPassword().getText());
        String nextUrl = "https://rahulshettyacademy.com/angularpractice/shop";
        driverWait.until(ExpectedConditions.urlToBe(nextUrl));
        Assert.assertEquals(driver.getCurrentUrl(), nextUrl);
    }

    
}
