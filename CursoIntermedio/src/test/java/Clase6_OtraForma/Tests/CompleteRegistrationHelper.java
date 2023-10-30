package Clase6_OtraForma.Tests;

import Clase6_OtraForma.Pages.*;
import Clase6_OtraForma.Utilities.Constants;

public class CompleteRegistrationHelper extends BaseTest{

    public static void completeRegistration(String emailAddress) throws InterruptedException{

        landingPage = new LandingPage(driver);

        loginPage = landingPage.goToLoginPage();

        loginPage.completeNameNewUserSignUp();
        loginPage.completeEmailNewUserSignUp(emailAddress);

        signUpPage = loginPage.goToSignUpPage();

        signUpPage.completeUserInformationFields(Constants.PASS);

    }
}
