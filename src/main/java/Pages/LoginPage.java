package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    private WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Locators
    @FindBy(how= How.PARTIAL_LINK_TEXT, using = "Inicia") private WebElement login_button;
    @FindBy(className="submit_btn") private WebElement session_button;
    @FindBy(className="error_msg") private WebElement error_login_message;
    @FindBy(id="email") private WebElement email_text;
    @FindBy(id="password") private WebElement password_text;
    @FindBy(how= How.CLASS_NAME, using = "plus_add_button") private WebElement plus_add_button;
    @FindBy(how= How.CLASS_NAME, using = "public-DraftStyleDefault-block") private WebElement task_text;
    @FindBy(className="user_avatar") private WebElement profile_button;
    @FindBy(className="markdown_content") private WebElement single_task;
    @FindBy(className="markdown_content") private List <WebElement> multiple_task;
/*
    @FindBy(xpath="//*[@id='__next']/div/main/div[1]/header/nav/div/ul[2]/li[1]/a") private WebElement login_button;
    @FindBy(xpath="//*[@id='login_form']/button") private WebElement session_button;
    @FindBy(xpath = "/html/body/main/div/div[2]/div[1]/div[2]/div/span") private WebElement error_login_message;
*/


    // Funciones de login y tasks
    public void Login(String user, String pass){
        login_button.click();
        email_text.sendKeys(user);
        password_text.sendKeys(pass);
        session_button.click();
    }

    public void AddTask(String taskname){
        plus_add_button.click();
        task_text.sendKeys(taskname);
        task_text.sendKeys(Keys.RETURN);
    }


    public void ClickPlusButton(){
        plus_add_button.click();
    }

    public void AddMultipleTask(String taskname){
        task_text.sendKeys(taskname);
        task_text.sendKeys(Keys.RETURN);
    }

    //Metodos de validacion

    public boolean validateLogin(){

        return profile_button.isDisplayed();
    }

    public String validateFailedLogin(){

        return error_login_message.getText();
    }

    public String validateSingleTask(){

        return single_task.getText();
    }

    public int validateMultipleTask(){
        System.out.println(multiple_task.size());
        return multiple_task.size();
    }
}
