package Clase6_OtraForma.Tests;

import Clase6_OtraForma.Utilities.Constants;
import Clase6_OtraForma.Utilities.EccomerceHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAccountTest extends BaseTest {

    @Test()
    public void loginAccountTest() throws InterruptedException {

        String email = EccomerceHelper.getEmailAddressRandom();
        CompleteRegistrationHelper.completeRegistration(email); // Invoco función CompleteRegistration de CompleteRegistrationHelper

        myAccountPage = signUpPage.goToMyAccountPage();

        landingPage.goToLoginPage();
        loginPage = myAccountPage.clikOnLogoutBtn();

        //Valido que estoy de nuevo en page Login
        String txtLog = loginPage.getH2LoginToYourAccount();
        Assert.assertEquals(Constants.LOGIN_TO_YOUR_ACCOUNT, txtLog);

        loginPage.completeInfoToLogin(email, Constants.PASS);

        myAccountPage = loginPage.goToMyAccountPage();
        String txtLogout = myAccountPage.txtLogout();

        Assert.assertEquals(txtLogout, Constants.LOGOUT); // Valido que estoy logueado

    }

}
