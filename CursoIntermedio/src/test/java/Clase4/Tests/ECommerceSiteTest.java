package Clase4.Tests;

import Clase4.Pages.LandingPage;
import Clase4.Pages.LoginPage;
import Clase4.Pages.MyAccountPage;
import Clase4.Pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ECommerceSiteTest {
    public WebDriver driver;
    public static String H2_SIGNUP = "New User Signup!";
    public static String ENTER_ACCOUNT = "ENTER ACCOUNT INFORMATION";
    public static String msjErrorEmailAlreadyExist = "Email Address already exist!";
    private LandingPage landingPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        landingPage = new LandingPage(driver);
        //Faker fake = new Faker();
    }

    @Test
    public void registrationAccountTest() throws InterruptedException {

        String emailAddress = "seleniumintermedio" + Math.random() + "test@gmail.com";
        String PASS = "1234";

        loginPage = landingPage.goToLoginPage();

        String sUp = loginPage.getNewUserSignUp();
        Assert.assertEquals(H2_SIGNUP, sUp);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login", "Se esperaba otra URL!!");

        loginPage.completeNameNewUserSignUp();

        loginPage.completeEmailNewUserSignUp(emailAddress);

        SignUpPage signUpPage = loginPage.goToSignUpPage();

        //Valido que estoy ubicado dentro de signUp
        boolean EAccountTitle = signUpPage.validateEnterAccountTitle(ENTER_ACCOUNT);
        Assert.assertTrue(EAccountTitle);

        //Valido que exista el mismo email que ingresé previamente
        String sEmail = signUpPage.existeEmail();
        Assert.assertEquals(sEmail, emailAddress, "Error, los Email no son iguales");

        signUpPage.completeUserInformationFields(PASS);

        MyAccountPage myAccountPage = signUpPage.goToMyAccountPage();

        boolean accountCreated = myAccountPage.txtAccountCreated();
        Assert.assertTrue(accountCreated);

        myAccountPage.btnContinuar();

        String txtLogout = myAccountPage.txtLogout();

        Assert.assertEquals(txtLogout, "Logout");
    }



    @Test
    public void loginAccountTest() throws InterruptedException {

        String emailAddress = "seleniumintermedio" + Math.random() + "test@gmail.com";
        String PASS = "1234";

        loginPage = landingPage.goToLoginPage();

        String sUp = loginPage.getNewUserSignUp();
        Assert.assertEquals(H2_SIGNUP, sUp);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login", "Se esperaba otra URL!!");

        loginPage.completeNameNewUserSignUp();
        loginPage.completeEmailNewUserSignUp(emailAddress);

        SignUpPage signUpPage = loginPage.goToSignUpPage();

        //Valido que estoy ubicado dentro de signUp
        boolean EAccountTitle = signUpPage.validateEnterAccountTitle(ENTER_ACCOUNT);
        Assert.assertTrue(EAccountTitle);

        //Valido que exista el mismo email con el inicié la autentiacion
        String sEmail = signUpPage.existeEmail();
        Assert.assertEquals(sEmail, emailAddress, "Error, los Email no son iguales");

        signUpPage.completeUserInformationFields(PASS);

        MyAccountPage myAccountPage = signUpPage.goToMyAccountPage();

        boolean accountCreated = myAccountPage.txtAccountCreated();
        Assert.assertTrue(accountCreated);

        myAccountPage.btnContinuar();

        String txtLogout = myAccountPage.txtLogout();
        Assert.assertEquals(txtLogout, "Logout");

        //Aparece ventana Advertisement
        //Cómo puedo quitarla ??

        myAccountPage.goToLoginPage();

        //Valido que estoy de nuevo en page Login

        String txtLog = loginPage.getH2LoginToYourAccount();
        Assert.assertEquals("Login to your account", txtLog);

        loginPage.completeInfoToLogin(emailAddress,PASS);

        MyAccountPage myAccountPage1 = loginPage.goToMyAccountPagePage();

        Assert.assertEquals(txtLogout,"Logout"); // Valido que estoy logueado

    }

    @Test
    public void uniqueAccountTest() throws InterruptedException{
        String emailAddress = "seleniumintermedio" + Math.random() + "test@gmail.com";
        String PASS = "1234";

        loginPage = landingPage.goToLoginPage();

        String sUp = loginPage.getNewUserSignUp();
        Assert.assertEquals(H2_SIGNUP, sUp);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login", "Se esperaba otra URL!!");

        loginPage.completeNameNewUserSignUp();
        loginPage.completeEmailNewUserSignUp(emailAddress);

        SignUpPage signUpPage = loginPage.goToSignUpPage();

        //Valido que estoy ubicado dentro de signUp
        boolean EAccountTitle = signUpPage.validateEnterAccountTitle(ENTER_ACCOUNT);
        Assert.assertTrue(EAccountTitle);

        //Valido que exista el mismo email con el inicié la autentiacion
        String sEmail = signUpPage.existeEmail();
        Assert.assertEquals(sEmail, emailAddress, "Error, los Email no son iguales");

        signUpPage.completeUserInformationFields(PASS);

        MyAccountPage myAccountPage = signUpPage.goToMyAccountPage();

        boolean accountCreated = myAccountPage.txtAccountCreated();
        Assert.assertTrue(accountCreated);

        myAccountPage.btnContinuar();

        String txtLogout = myAccountPage.txtLogout();
        Assert.assertEquals(txtLogout, "Logout");

        //Aparece ventana Advertisement
        //Cómo puedo quitarla ??

        myAccountPage.goToLoginPage();
        //Thread.sleep(3000);

        //Vuelvo a registrarme con la misma cuenta
        loginPage.completeNameNewUserSignUp();
        loginPage.completeEmailNewUserSignUp(emailAddress);
        SignUpPage signUpPage1 = loginPage.goToSignUpPage();

        String txtExisteEmail = loginPage.getEmailAlreadyExists();

        Assert.assertEquals(txtExisteEmail,msjErrorEmailAlreadyExist, "Error, no se encontró msj de error");

    }


}
