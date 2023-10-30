package Clase6_OtraForma.Tests;

//Este codigo está refactoreado con patron PageObject con las siguientes clases:
//LandingPage
//LoginPage
//MyAccountPage
//SignUpPage
//BaseTest
//CompleteRegistrationTest
//CreateNewAccountTest
//LoginAccountTest
//UniqueAccountTest
//Constants



/*package Clase5.Tests;

import Clase5.Pages.LandingPage;
import Clase5.Pages.LoginPage;
import Clase5.Pages.MyAccountPage;
import Clase5.Pages.SignUpPage;
import Clase5.Utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ECommerceSiteTest extends BaseTest{

    public WebDriver driver;
    private String emailAddress = "seleniumintermedio" + Math.random() + "test@gmail.com";
    private LandingPage landingPage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private SignUpPage signUpPage;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        landingPage = new LandingPage(driver);

        loginPage = landingPage.goToLoginPage();

        String txtNewUserSUp = loginPage.getNewUserSignUp();
        Assert.assertEquals(Constants.H2_SIGNUP, txtNewUserSUp);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login", "Se esperaba otra URL!!");

        loginPage.completeNameNewUserSignUp();
        loginPage.completeEmailNewUserSignUp(emailAddress);

        signUpPage = loginPage.goToSignUpPage();

        //Valido que estoy ubicado dentro de signUp
        boolean EAccountTitle = signUpPage.validateEnterAccountTitle(Constants.ENTER_ACCOUNT);
        Assert.assertTrue(EAccountTitle);

        //Valido que exista el mismo email que ingresé previamente
        String sEmail = signUpPage.existeEmail();
        Assert.assertEquals(sEmail, emailAddress, "Error, los Email no son iguales");

        signUpPage.completeUserInformationFields(Constants.PASS);

        myAccountPage = signUpPage.goToMyAccountPage();

        boolean accountCreated = myAccountPage.txtAccountCreated();
        Assert.assertTrue(accountCreated);

        myAccountPage.btnContinuar();

        String txtLogout = myAccountPage.txtLogout();

        Assert.assertEquals(txtLogout, Constants.LOGOUT);

    }

    @Test
    public void loginTest() throws InterruptedException{
        loginPage = landingPage.goToLoginPage();

        String txtNewUserSUp = loginPage.getNewUserSignUp();
        Assert.assertEquals(Constants.H2_SIGNUP, txtNewUserSUp);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login", "Se esperaba otra URL!!");

        loginPage.completeNameNewUserSignUp();
        loginPage.completeEmailNewUserSignUp(emailAddress);

        signUpPage = loginPage.goToSignUpPage();

        //Valido que estoy ubicado dentro de signUp
        boolean EAccountTitle = signUpPage.validateEnterAccountTitle(Constants.ENTER_ACCOUNT);
        Assert.assertTrue(EAccountTitle);

        //Valido que exista el mismo email que ingresé previamente
        String sEmail = signUpPage.existeEmail();
        Assert.assertEquals(sEmail, emailAddress, "Error, los Email no son iguales");

        signUpPage.completeUserInformationFields(Constants.PASS);

        myAccountPage = signUpPage.goToMyAccountPage();

        boolean accountCreated = myAccountPage.txtAccountCreated();
        Assert.assertTrue(accountCreated);

        myAccountPage.btnContinuar();

        String txtLogout = myAccountPage.txtLogout();

        Assert.assertEquals(txtLogout, Constants.LOGOUT);


    }


    @Test
    public void loginAccountTest() throws InterruptedException {

        //Aparece ventana Advertisement
        //Cómo puedo quitarla ??

        loginPage = myAccountPage.clikOnLogoutBtn();

        //Valido que estoy de nuevo en page Login
        String txtLog = loginPage.getH2LoginToYourAccount();
        Assert.assertEquals(Constants.LOGIN_TO_YOUR_ACCOUNT, txtLog);

        loginPage.completeInfoToLogin(emailAddress,Constants.PASS);

        myAccountPage = loginPage.goToMyAccountPage();
        String txtLogout = myAccountPage.txtLogout();

        Assert.assertEquals(txtLogout,Constants.LOGOUT); // Valido que estoy logueado

    }

    @Test
    public void uniqueAccountTest() throws InterruptedException{

        loginPage = myAccountPage.clikOnLogoutBtn();
        //Thread.sleep(3000);

        //Vuelvo a intentar registrarme con la misma cuenta
        loginPage.completeNameNewUserSignUp();
        loginPage.completeEmailNewUserSignUp(emailAddress);
        signUpPage = loginPage.goToSignUpPage();

        String txtExisteEmail = loginPage.getEmailAlreadyExists();

        Assert.assertEquals(txtExisteEmail,Constants.MSJ_ERROR_EmailAlreadyExist, "Error, no se encontró msj de error");

    }







}
*/