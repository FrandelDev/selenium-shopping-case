package shoppingcase;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class Main{
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        @SuppressWarnings("rawtypes")
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //https://rahulshettyacademy.com/AutomationPractice/
        //https://rahulshettyacademy.com/dropdownsPractise/
        //https://rahulshettyacademy.com/loginpagePractise/
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        SecureRandom randomOption = new SecureRandom();
       

    driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
    driver.findElement(By.id("password")).sendKeys("learning");
    driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
    
      
        
    wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
    driver.findElement(By.id("okayBtn")).click();
    
    WebElement select = driver.findElement(By.cssSelector(".form-control[data-style='btn-info']"));
    Select selectable = new Select(select);
    selectable.selectByIndex(randomOption.nextInt(0, 3));

    driver.findElement(By.id("terms")).click();

    driver.findElement(By.id("signInBtn")).click();

    String nextUrl = "https://rahulshettyacademy.com/angularpractice/shop";
    wait.until(ExpectedConditions.urlToBe(nextUrl));
    Assert.assertEquals(driver.getCurrentUrl(), nextUrl);









    

    List<WebElement> addBtns = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
  
    addBtns.forEach((element)->{
        element.click();
    });

    driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
    driver.findElement(By.cssSelector("td .btn-success")).click();
    
    
    driver.findElement(By.id("country")).sendKeys("Alba");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".suggestions a")));
    driver.findElement(By.cssSelector(".suggestions a")).click();
    driver.findElement(By.cssSelector("input[value='Purchase']")).click();
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div .alert-success")));
    Assert.assertTrue(driver.findElement(By.cssSelector("div .alert-success")).getText().contains("Thank you! Your order will be delivered in next few weeks :-)."));
    
    }
}