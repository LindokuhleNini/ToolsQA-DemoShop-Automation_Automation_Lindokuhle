import application.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AppTests extends BaseTests {

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
        loginPage.clickLoginButton();

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

    @Test(priority = 3)
    public void testItemAddedToCart() throws InterruptedException {

        dashboard = new Dashboard(driver);
        cart = new Cart(driver);
        dashboard.navigateToProducts();
        String prodTitle = excelHelper.getCellDataString(2, 3);
        String color = excelHelper.getCellDataString(2, 4);
        String size = ""+excelHelper.getCellDataInt(2, 5);

        products.selectProduct(prodTitle.toUpperCase());

        String oldCartTotal = cart.cartTotal();
        products.chooseColor(color);
        products.chooseSize(size);
        products.addToCart();

        String newCartTotal = cart.cartTotal();
        assertNotEquals(oldCartTotal, newCartTotal);

        products.clickMyAccount();
        products.logout();
    }

    @Test(priority = 4)
    public void testCheckout() throws InterruptedException {
        testSuccessfulLogin();
        products.openCart();
        cart.proceedToCheckout();

        checkout = new Checkout(driver);
        Thread.sleep(2000);
        checkout.placeOrder();
        Thread.sleep(2000);
        products.clickMyAccount();

        confirmation = new Confirmation(driver);
        confirmation.displayOrders();
        Thread.sleep(2000);
    }
}
