package Pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;



public class BasePage {

    public String baseUrl = "https://todoist.com/";
    String driverPath = "/Users/Jorsh/Downloads/PruebasSelenium/chromedriver";
    public WebDriver driver;
   /* public void launchBrowser(){

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
*/
}
