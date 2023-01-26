package login;

import application.Dashboard;
import application.Home;
import application.Login;
import application.Products;
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


        Home home = dashboard.clickHome();
        home.selectProduct();
        products.chooseColor();
        products.chooseSize();
        products.addToCart();
        products.openCart();

        /*assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");*/
    }
}
