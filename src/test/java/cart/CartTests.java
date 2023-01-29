package cart;

import application.Cart;
import application.Dashboard;
import application.Products;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

public class CartTests extends BaseTests {

    @Test(priority = 3)
    public void testItemAddedToCart() throws InterruptedException {

        //Products prod = dashboard.navigateToProducts();
        //Thread.sleep(1000);
        products.selectProduct();
        Thread.sleep(1000);

        String oldCartTotal = cart.cartTotal();
        products.chooseColor();
        Thread.sleep(1000);
        products.chooseSize();
        Thread.sleep(1000);
        products.addToCart();
        Thread.sleep(1000);
        products.openCart();
        Thread.sleep(1000);

        String newCartTotal = cart.cartTotal();
        assertNotEquals(oldCartTotal, newCartTotal);

        products.clickMyAccount();
        products.logout();
    }
}
