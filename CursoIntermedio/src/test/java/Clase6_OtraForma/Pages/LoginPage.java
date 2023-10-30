package Clase6_OtraForma.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
        //Inicializo los elementos @FindBy
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "signup-form")
    public WebElement signUp;
    @FindBy(xpath = "//*[@name='name']")
    public WebElement name;
    @FindBy(xpath = "//*[@data-qa='signup-email']")
    public WebElement signupEmail;
    @FindBy(xpath = "//*[@data-qa='signup-button']")
    public WebElement signupBtn;
    @FindBy(className = "login-form")
    public WebElement login;
    @FindBy(xpath = "//*[@data-qa='login-email']")
    public WebElement logEmail;
    @FindBy(xpath = "//*[@data-qa='login-password']")
    public WebElement logPass;
    @FindBy(xpath = "//*[@data-qa='login-button']")
    public WebElement logBtn;
    @FindBy(xpath = "//*[@action='/signup']")
    public WebElement formSignUp;


    public String getTitleNewUserSignUp(){
        //WebElement signUp = driver.findElement(By.className("signup-form"));
        return signUp.findElement(By.tagName("h2")).getText();
    }

    public void completeNameNewUserSignUp(){
        //WebElement name = driver.findElement(By.xpath("//*[@name='name']"));
        name.sendKeys("Test");
    }

    public void completeEmailNewUserSignUp(String emailAddress){
        //WebElement signupEmail = driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
        signupEmail.sendKeys(emailAddress);
    }

    public SignUpPage goToSignUpPage(){
        //WebElement signupBtn = driver.findElement(By.xpath("//*[@data-qa='signup-button']"));
        signupBtn.click();
        SignUpPage nextSignUpPage = new SignUpPage(driver);
        return nextSignUpPage;
    }

    public String getH2LoginToYourAccount(){
        //WebElement login = driver.findElement(By.className("login-form"));
        return login.findElement(By.tagName("h2")).getText();
    }

    public void completeInfoToLogin(String emailAddress, String pass){
        //WebElement logEmail = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
        //WebElement logPass = driver.findElement(By.xpath("//*[@data-qa='login-password']"));
        logEmail.sendKeys(emailAddress);
        logPass.sendKeys(pass);
    }


    public MyAccountPage goToMyAccountPage(){
        //WebElement logBtn = driver.findElement(By.xpath("//*[@data-qa='login-button']"));
        logBtn.click();
        MyAccountPage nextMyAccountPage = new MyAccountPage(driver);
        return nextMyAccountPage;
    }

    public String getEmailAlreadyExists(){
        //WebElement formSignUp = driver.findElement(By.xpath("//*[@action='/signup']"));
        return formSignUp.findElement(By.tagName("p")).getText();
    }
}
