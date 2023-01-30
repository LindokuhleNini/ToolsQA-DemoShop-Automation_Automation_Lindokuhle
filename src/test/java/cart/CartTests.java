package cart;

import application.Cart;
import application.Dashboard;
import application.Products;
import base.BaseTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

public class CartTests extends BaseTests {

    @Parameters("url")
    @Test(priority = 3)
    public void testItemAddedToCart() throws InterruptedException {

        //Products prod = dashboard.navigateToProducts();
        String prodTitle = excelHelper.getCellDataString(2, 3);
        String color = excelHelper.getCellDataString(2, 4);
        String size = ""+excelHelper.getCellDataInt(2, 5);

        Thread.sleep(1000);
        products.selectProduct(prodTitle);
        Thread.sleep(1000);

        String oldCartTotal = cart.cartTotal();
        products.chooseColor(color);
        Thread.sleep(1000);
        products.chooseSize(size);
        Thread.sleep(1000);
        products.addToCart();
        Thread.sleep(1000);
        products.openCart();
        Thread.sleep(1000);

        String newCartTotal = cart.cartTotal();
        assertNotEquals(oldCartTotal, newCartTotal);

       /* products.clickMyAccount();
        products.logout();*/
    }
}
