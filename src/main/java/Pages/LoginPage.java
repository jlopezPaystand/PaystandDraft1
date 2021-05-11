package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    //Locators for PAYSTAND
    /*
    @FindBy (className="total_amount") private WebElement amount_text;
    @FindBy (className="payer_email") private WebElement payer_email;
    @FindBy(how= How.PARTIAL_LINK_TEXT, using = "Bank") private WebElement rails_bank;
    @FindBy(how= How.PARTIAL_LINK_TEXT, using = "ACH") private WebElement rails_ACH;
    @FindBy(how= How.PARTIAL_LINK_TEXT, using = "Card") private WebElement rails_card;
    @FindBy(xpath = "//*[@id=\'ps_checkout_form\']/ng-include/div/div/ng-include/div/div[5]/div/div/div/div/ps-widget/ps-fund-select-type/ng-form/ng-include/div/fieldset/div[2]/button[2]") private WebElement rails_card;
    @FindBy (className="search_banks") private WebElement search_banks;
    @FindBy (className="card_name") private WebElement card_name;
    @FindBy (className="card_number") private WebElement card_number;
    @FindBy (className="card_expiry") private WebElement card_expiry;
    @FindBy (className="card_security_code") private WebElement security_code;
    @FindBy(how= How.PARTIAL_LINK_TEXT, using = "Enter Billing Information") private WebElement enter_billing_button;
    */

    //Locators Paystand by XPATH

    //Checkout 1st screen
    @FindBy (id="input_0") private WebElement amount_text;
    @FindBy (id="input_3") private WebElement payer_email;
    @FindBy (xpath="//*[@id=\'ps_checkout_form\']/ng-include/div/div/ng-include/div/div[5]/div/div/div/div/ps-widget/ps-fund-select-type/ng-form/ng-include/div/fieldset/div[2]/button[1]")private WebElement rails_bank;
    @FindBy (xpath ="//*[@id=\'ps_checkout_form\']/ng-include/div/div/ng-include/div/div[5]/div/div/div/div/ps-widget/ps-fund-select-type/ng-form/ng-include/div/fieldset/div[2]/button[2]") private WebElement rails_card;
    @FindBy (xpath="//*[@id=\'ps_checkout_form\']/ng-include/div/div/ng-include/div/div[5]/div/div/div/div/ps-widget/ps-fund-select-type/ng-form/ng-include/div/fieldset/div[2]/button[3]") private WebElement rails_ACH;

    //Checkout Bank screen
    @FindBy (id="input_24") private WebElement card_name;
    @FindBy (id="input_19") private WebElement card_number;
    @FindBy (id="input_20") private WebElement card_expiry;
    @FindBy (id="input_21") private WebElement security_code;
    @FindBy(xpath= "//*[@id=\'ps_checkout_form\']/ng-include/div/div/ng-include/div/div[6]/div/div/div/div[1]/ps-widget/ps-card-edit/ng-form/ng-include/ng-include/div/fieldset/ng-include[2]/div/ps-button[3]/button") private WebElement enter_billing_button;

    //Checkout Card screen - CHASE
    @FindBy (id="input-2") private WebElement search_banks;
    @FindBy (name = "login_username") private WebElement bank_username;
    @FindBy (name="login_password") private WebElement bank_password;
    @FindBy(xpath= "//*[@id=\'ps_checkout_form\']/ng-include/div/div/ng-include/div/div[6]/div/div/div/div[3]/ps-widget/ps-bank-session-choose/ng-form/ng-include/div/div[2]/ng-include/div/ng-include/div/ps-button[3]/button") private WebElement banks_next_button;
    @FindBy(xpath= "//*[@id=\'ps_checkout_form\']/ng-include/div/div/ng-include/div/div[4]/div/div/div/div/ps-widget/ps-bank-session/ng-form/ng-include/div/div/ps-bank-session-login/ng-form/ng-include/div/fieldset/ng-include[2]/div/ps-button[3]/button/span") private WebElement secure_login_button;

    //Checkout Card Billing page
    @FindBy (id ="input_27") private WebElement address_street;
    @FindBy (id="input_28") private WebElement address_city;
    @FindBy (id="input_29") private WebElement address_postal;
    @FindBy (id="input-25") private WebElement address_country;
    @FindBy (id="input-26") private WebElement address_state;
    @FindBy(xpath="//*[@id=\'ps_checkout_form\']/ng-include/div/div/ng-include/div/div[5]/div/div/div/div/ps-widget/ps-address-edit/ng-form/ng-include/ng-include/div/fieldset/ng-include[2]/div/ps-button[3]/button") private WebElement pay_button_checkout;
    @FindBy(xpath="//*[@id=\'ps_checkout_form\']/ng-include/div/div/ng-include/div/div[4]/div/div/div/div/ps-widget/ps-receipt-view/ng-form/ng-include/ng-include/div/div[1]/div/div[5]/div/div/button") private WebElement requestAccessButton;


// Funciones Paystand 4242424242424242

    public void SelectBank (String amount, String email, String bankName){

        //rails_bank.click();
        amount_text.clear();
        amount_text.sendKeys(amount);
        payer_email.sendKeys(email);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        search_banks.sendKeys(bankName);
        banks_next_button.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void SubmitBankCredentials (String username, String password){
        bank_username.sendKeys(username);
        bank_password.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        secure_login_button.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void SubmitCard(String amount, String email, String name, String number, String date, String CSC){
        rails_card.click();
        amount_text.clear();
        amount_text.sendKeys(amount);
        payer_email.sendKeys(email);
        card_name.sendKeys(name);
        card_number.sendKeys(number);
        card_expiry.sendKeys(date);
        security_code.sendKeys(CSC);
        enter_billing_button.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void SubmitPayment(String address, String city, String postal, String country, String state){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        address_street.sendKeys(address);
        address_city.sendKeys(city);
        address_postal.sendKeys(postal);
        //address_country.sendKeys(country);
        address_state.sendKeys(state);
        pay_button_checkout.click();
    }
    public boolean validatePayment(){
        /*String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(text));

        String PaymentCompleted = driver.findElement(By.tagName("Payment Completed")).getText();
        Assert.assertTrue("Payment Completed", PaymentCompleted.contains(PaymentCompleted));
*/

        return requestAccessButton.isDisplayed();
    }
/*

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
*/


}
