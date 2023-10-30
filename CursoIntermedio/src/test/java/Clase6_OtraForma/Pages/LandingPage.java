package Clase6_OtraForma.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {


        public LandingPage(WebDriver remoteDriver){
            this.driver = remoteDriver;
            //Inicializo los elementos @FindBy
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//*[@href='/login']")
        public WebElement btnSignUp_Login;

        public LoginPage goToLoginPage(){
            //WebElement signUp = driver.findElement(By.xpath("//*[@href='/login']"));
            btnSignUp_Login.click();
            LoginPage nextPage = new LoginPage(driver);
            return nextPage;
        }
}
