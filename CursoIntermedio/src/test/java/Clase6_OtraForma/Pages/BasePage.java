package Clase6_OtraForma.Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;

    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
