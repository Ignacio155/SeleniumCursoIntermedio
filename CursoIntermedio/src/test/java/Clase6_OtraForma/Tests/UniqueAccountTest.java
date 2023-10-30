package Clase6_OtraForma.Tests;

import Clase6_OtraForma.Utilities.Constants;
import Clase6_OtraForma.Utilities.EccomerceHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UniqueAccountTest extends BaseTest {

    @Test()
    public void uniqueAccountTest() throws InterruptedException{

        String email = EccomerceHelper.getEmailAddressRandom();
        CompleteRegistrationHelper.completeRegistration(email);

        myAccountPage = signUpPage.goToMyAccountPage();

        landingPage.goToLoginPage();
        Thread.sleep(3000);
        loginPage = myAccountPage.clikOnLogoutBtn();

        //Vuelvo a intentar registrarme con la misma cuenta
        loginPage.completeNameNewUserSignUp();
        loginPage.completeEmailNewUserSignUp(email);
        signUpPage = loginPage.goToSignUpPage();

        String txtExisteEmail = loginPage.getEmailAlreadyExists();

        Assert.assertEquals(txtExisteEmail, Constants.MSJ_ERROR_EmailAlreadyExist, "Error, no se encontró msj de error");


    }

}
