package Clase4.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SignUpPage {

    public WebDriver driver;

    public SignUpPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
    }

    public boolean validateEnterAccountTitle(String EnterAccount){
        List<WebElement> bs = driver.findElements(By.tagName("b"));

        boolean encontro = false;
        for (WebElement b : bs) {
            if (b.getText().contains(EnterAccount)) {
                //System.out.println(b.getText());
                encontro = true;
                break;
            }
            encontro = true;
        }
        return encontro;
    }

    public String existeEmail(){
        WebElement txtEmail = driver.findElement(By.id("email"));
        String sEmail = txtEmail.getAttribute("value");
        return sEmail;
    }

    public void completeUserInformationFields(String PASS){

        WebElement title = driver.findElement(By.id("id_gender1"));
        WebElement password = driver.findElement(By.id("password"));
        Select dia = new Select(driver.findElement(By.id("days")));
        Select mes = new Select(driver.findElement(By.id("months")));
        Select anio = new Select(driver.findElement(By.id("years")));
        WebElement firstName = driver.findElement(By.id("first_name"));
        WebElement lastName = driver.findElement(By.id("last_name"));
        WebElement company = driver.findElement(By.id("company"));
        WebElement address = driver.findElement(By.id("address1"));
        WebElement address2 = driver.findElement(By.id("address2"));
        Select country = new Select(driver.findElement(By.id("country")));
        WebElement state = driver.findElement(By.id("state"));
        WebElement city = driver.findElement(By.id("city"));
        WebElement zip = driver.findElement(By.id("zipcode"));
        WebElement cel = driver.findElement(By.id("mobile_number"));

        title.click();
        password.sendKeys(PASS);
        dia.selectByValue("1");
        mes.selectByValue("10");
        anio.selectByValue("1993");
        firstName.sendKeys("Test");
        lastName.sendKeys("Test");
        company.sendKeys("CompanyTest");
        address.sendKeys("Test 2424");
        address2.sendKeys("Prueba 5555");
        country.selectByValue("Australia");
        state.sendKeys("Nueva gales del sur");
        city.sendKeys("Sydney");
        zip.sendKeys("123456789");
        cel.sendKeys("099111222");

        driver.manage().window().fullscreen();

    }

    public MyAccountPage goToMyAccountPage(){
        WebElement btnCrear = driver.findElement(By.xpath("//*[@data-qa='create-account']"));
        btnCrear.click();
        MyAccountPage nextMyAccountPage = new MyAccountPage(driver);
        return nextMyAccountPage;
    }
}
