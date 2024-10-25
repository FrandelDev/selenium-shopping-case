package shoppingcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseConfig {

    private static WebDriver driver;
    private static BaseConfig baseConfigInstance;


    private BaseConfig(){
        driver = new ChromeDriver();
    }

    public static BaseConfig getInstance(){
        if (baseConfigInstance == null) {
            baseConfigInstance = new BaseConfig();
        }
        return baseConfigInstance;
    }
    
    public static WebDriver getDriverInstance(){
        return driver;
    }

    public WebDriver initialize(){
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        return getDriverInstance();
    }

}
