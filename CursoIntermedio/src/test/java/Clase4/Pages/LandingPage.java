package Clase4.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage{
        public WebDriver driver;

        public LandingPage(WebDriver remoteDriver){
            this.driver = remoteDriver;
        }

        public LoginPage goToLoginPage(){
            WebElement signUp = driver.findElement(By.xpath("//*[@href='/login']"));
            signUp.click();
            LoginPage nextPage = new LoginPage(driver);
            return nextPage;
        }
}
