package Clase6_OtraForma.Tests;

import Clase6_OtraForma.Pages.LandingPage;
import Clase6_OtraForma.Pages.LoginPage;
import Clase6_OtraForma.Pages.MyAccountPage;
import Clase6_OtraForma.Pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    protected static LandingPage landingPage;
    protected static LoginPage loginPage;
    protected static MyAccountPage myAccountPage;
    protected static SignUpPage signUpPage;


    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        landingPage = new LandingPage(driver);

    }
    @AfterMethod
    public void closeDriver(){
        driver.close();
    }


}
