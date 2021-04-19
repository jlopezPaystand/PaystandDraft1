package Tests;


import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class LoginTest{
    WebDriver driver;
    public String baseUrl = "https://todoist.com/es";
    public String pageUser = "jorgebarriba@gmail.com";
    public String pagePassword = "Challenge02";
    public String failedUser = "failed@gmail.com";
    public String failedPassword = "nopass";
    public String singleTaskName = "Automated Single Task";
    public String multipleTaskName = "Automated Task Number ";
    public String errorLoginMessage = "Email o contraseña incorrectos";

    @Before
    public void launchBrowser() throws InterruptedException {
        String driverPath = "src/WebDriver/chromedriver3";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @Test
    public void SuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(pageUser, pagePassword);
        org.junit.Assert.assertTrue(loginPage.validateLogin());
    }

    @Test
    public void UnsuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(failedUser, failedPassword);
        org.junit.Assert.assertEquals(errorLoginMessage,loginPage.validateFailedLogin());
    }

   @Test
    public void CreateNewTask(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(pageUser, pagePassword);
        loginPage.AddTask(singleTaskName);
        org.junit.Assert.assertEquals(singleTaskName,loginPage.validateSingleTask());
    }

    @Test
    public void Create10Tasks(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(pageUser, pagePassword);
        loginPage.ClickPlusButton();
        int n = 1;
        while(n<11){
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            loginPage.AddMultipleTask(multipleTaskName+n);
            n++;
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertEquals(10,loginPage.validateMultipleTask());

    }

    @After
    public void close() throws InterruptedException {
        Thread.sleep(100);
        driver.close();
    }

}
