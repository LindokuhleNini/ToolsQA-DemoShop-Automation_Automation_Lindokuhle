package login;

import application.Login;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
    @Test
    public void testSuccessfulLogin()
    {
        Login loginPage = home.clickMyAccount();
        loginPage.setUsername("Lindokuhle");
        loginPage.setPassword("Testing@12345");
        loginPage.clickLoginButton();

        assertFalse(loginPage.loginErrorVisible(),
                "The username or password is incorrect");
    }

    @Test
    public void testUnsuccessfulLogin()
    {
        Login loginPage = home.clickMyAccount();
        loginPage.setUsername("Lindokuhle");
        loginPage.setPassword("Testing@123");
        loginPage.clickLoginButton();

        assertTrue(loginPage.loginErrorVisible(),
                "The username or password is incorrect");
    }
}
