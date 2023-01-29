package login;

import application.Home;
import application.Login;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {
    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        Login loginPage = home.clickMyAccount();
        loginPage.setUsername("Lindokuhle");
        loginPage.setPassword("Testing@12345");
        Thread.sleep(2000);
        loginPage.clickLoginButton();

        /*assertFalse(loginPage.loginErrorVisible(),
                "The username or password is incorrect");*/

        Home prod = dashboard.navigateToProducts();
        prod.selectProduct();
        Thread.sleep(2000);

        String oldCartTotal = cart.cartTotal();
        products.chooseColor();
        products.chooseSize();
        products.addToCart();
        products.openCart();

        String newCartTotal = cart.cartTotal();
        assertNotEquals(oldCartTotal, newCartTotal);
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
