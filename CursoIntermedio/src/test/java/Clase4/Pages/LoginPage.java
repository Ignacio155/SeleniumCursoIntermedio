package Clase4.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
    }

    public String getNewUserSignUp(){
        WebElement SignUp = driver.findElement(By.className("signup-form"));
        String sUp = SignUp.findElement(By.tagName("h2")).getText();
        return sUp;
    }

    public void completeNameNewUserSignUp(){
        WebElement name = driver.findElement(By.xpath("//*[@name='name']"));
        name.sendKeys("Test");
    }

    public void completeEmailNewUserSignUp(String emailAddress){
        WebElement signupEmail = driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
        signupEmail.sendKeys(emailAddress);
    }

    public SignUpPage goToSignUpPage(){
        WebElement signupBtn = driver.findElement(By.xpath("//*[@data-qa='signup-button']"));
        signupBtn.click();
        SignUpPage nextSignUpPage = new SignUpPage(driver);
        return nextSignUpPage;
    }

    public String getH2LoginToYourAccount(){
        WebElement login = driver.findElement(By.className("login-form"));
        String log = login.findElement(By.tagName("h2")).getText();
        return log;
    }

    public void completeInfoToLogin(String emailAddress, String PASS){
        WebElement logEmail = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
        WebElement logPass = driver.findElement(By.xpath("//*[@data-qa='login-password']"));
        logEmail.sendKeys(emailAddress);
        logPass.sendKeys(PASS);
    }

    public void btnLogin(){

    }

    public MyAccountPage goToMyAccountPagePage(){
        WebElement logBtn = driver.findElement(By.xpath("//*[@data-qa='login-button']"));
        logBtn.click();
        MyAccountPage nextMyAccountPage = new MyAccountPage(driver);
        return nextMyAccountPage;
    }

    public String getEmailAlreadyExists(){
        WebElement formSignUp = driver.findElement(By.xpath("//*[@action='/signup']"));
        WebElement txtExisteEmail = formSignUp.findElement(By.tagName("p"));
        return txtExisteEmail.getText();
    }
}
