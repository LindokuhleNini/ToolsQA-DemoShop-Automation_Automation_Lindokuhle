package cart;

import application.Home;
import base.BaseTests;
import org.testng.annotations.Test;

public class CartTests extends BaseTests {

    @Test
    public void testItemAddedToCart(){

        Home prod = dashboard.navigateToProducts();
        prod.selectProduct();
        products.chooseColor();
        products.chooseSize();
        products.addToCart();
        products.openCart();

        cart.cartTotal();

        home.clickMyAccount();
        home.logout();
    }
}
