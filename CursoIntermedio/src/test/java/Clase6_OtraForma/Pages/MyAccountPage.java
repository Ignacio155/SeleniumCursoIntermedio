package Clase6_OtraForma.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountPage extends BasePage {

        public MyAccountPage(WebDriver remoteDriver){
            this.driver = remoteDriver;
            //Inicializo los elementos @FindBy
            PageFactory.initElements(driver, this);
        }

        @FindBy(tagName = "b")
        List<WebElement> labels_b_title;
        @FindBy(xpath = "//*[@data-qa='continue-button']")
        public WebElement btnContinuar;
        @FindBy(xpath = "//*[@href='/logout']")
        public WebElement logout;
        @FindBy(xpath = "//*[a]")
        List<WebElement> getAllLinks;
        @FindBy(tagName = "li")
        List<WebElement> shopMenuLis;
        @FindBy(id = "aswift_0")
        public WebElement closeAdvertisement;


        public boolean txtAccountCreated(){
            //List<WebElement> b_tags = driver.findElements(By.tagName("b"));
            for (WebElement label_b : labels_b_title) {
                if (label_b.getText().contains("ACCOUNT CREATED!")) {
                    return true;
                }
            }
            return false;
        }

        public void btnContinuar(){
            //WebElement btnContinuar = driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
            btnContinuar.click();
        }

        public String txtLogout(){
            //WebElement logout = driver.findElement(By.xpath("//*[@href='/logout']"));
            return logout.getText();
        }

        public LoginPage clikOnLogoutBtn(){
            //WebElement logout = driver.findElement(By.xpath("//*[@href='/logout']"));
            logout.click(); //Me deslogueo
            LoginPage nextLoginPage = new LoginPage(driver);
            return nextLoginPage;
        }

        public void clicOnAdvertisement(){
            closeAdvertisement.click();
        }

        /*
        public ProductsPage clicBtnProductos(){
            for(WebElement shopMenuLi : shopMenuLis){
                if(shopMenuLi.getText().contains("Products")){
                    shopMenuLi.click();
                    ProductsPage nextProductPage = new ProductsPage(driver);
                    return nextProductPage;
                }
            }
            return null;
        }
        */

}
