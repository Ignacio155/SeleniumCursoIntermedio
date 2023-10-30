package Clase6_OtraForma.Tests;

import Clase6_OtraForma.Utilities.Constants;
import Clase6_OtraForma.Utilities.EccomerceHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompleteRegistrationTest extends BaseTest {

    @Test
    public void completeRegistration() throws InterruptedException{

        String email = EccomerceHelper.getEmailAddressRandom();
        CompleteRegistrationHelper.completeRegistration(email);

        //Valido que exista el mismo email que ingresé previamente
        String sEmail = signUpPage.existeEmail();
        Assert.assertEquals(sEmail, email, "Error, los Email no son iguales");

        myAccountPage = signUpPage.goToMyAccountPage();

        boolean accountCreated = myAccountPage.txtAccountCreated();
        Assert.assertTrue(accountCreated);

        myAccountPage.btnContinuar();

        String txtLogout = myAccountPage.txtLogout();

        Assert.assertEquals(txtLogout, Constants.LOGOUT);

    }

}
