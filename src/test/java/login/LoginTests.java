package login;

import application.Login;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
    @Test
    public void testSuccessfulLogin(){
        Login loginPage = home.clickMyAccount();
        loginPage.setUsername("Lindokuhle");
        loginPage.setPassword("Testing@12345");
        loginPage.clickLoginButton();
        /*assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");*/
    }
}
