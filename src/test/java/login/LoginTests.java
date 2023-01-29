package login;

import application.Login;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    //@Parameters("url")
    @Test(priority = 2)
    public void testSuccessfulLogin() throws InterruptedException {
        username = excelHelper.getCellDataString(2, 1);
        password = excelHelper.getCellDataString(2, 2);

        Login loginPage = products.clickMyAccount();
        Thread.sleep(1000);
        loginPage.setUsername(username);
        Thread.sleep(1000);
        loginPage.setPassword(password);
        Thread.sleep(1000);
        loginPage.clickLoginButton();
        Thread.sleep(1000);

        assertFalse(loginPage.loginErrorVisible(),
                "The username or password is incorrect");

    }

    @Test(priority = 1)
    public void testUnsuccessfulLogin() throws InterruptedException {
        Login loginPage = products.clickMyAccount();
        Thread.sleep(1000);
        loginPage.setUsername("Lindokuhle");
        Thread.sleep(1000);
        loginPage.setPassword("Testing@123");
        Thread.sleep(1000);
        loginPage.clickLoginButton();

        assertTrue(loginPage.loginErrorVisible(),
                "The username or password is incorrect");
    }
}
