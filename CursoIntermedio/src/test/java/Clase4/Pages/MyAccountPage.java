package Clase4.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class MyAccountPage{
        public WebDriver driver;

        public MyAccountPage(WebDriver remoteDriver){
            this.driver = remoteDriver;
        }

        public boolean txtAccountCreated(){
            List<WebElement> b_tags = driver.findElements(By.tagName("b"));
            boolean encontroTag = false;
            for (WebElement bt : b_tags) {
                if (bt.getText().contains("ACCOUNT CREATED!")) {
                    //System.out.println(bt.getText());
                    encontroTag = true;
                    break;
                }
                encontroTag=true;
            }
            return encontroTag;
        }

        public void btnContinuar(){
            WebElement btnContinuar = driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
            btnContinuar.click();
        }

        public String txtLogout(){
            WebElement logout = driver.findElement(By.xpath("//*[@href='/logout']"));
            return logout.getText();
        }

        public LoginPage goToLoginPage(){
            WebElement logout = driver.findElement(By.xpath("//*[@href='/logout']"));
            logout.click(); //Me deslogueo
            LoginPage nextLoginPage = new LoginPage(driver);
            return nextLoginPage;
        }
}
