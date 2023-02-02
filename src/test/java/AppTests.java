import application.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.source.tree.AssertTree;
import org.apache.poi.ss.formula.functions.DCount;
import org.testng.annotations.Test;
import utilities.ActionHelper;

import java.io.File;

import static org.testng.Assert.*;

public class AppTests extends BaseTests {

    File file = new File("report.html");
    ExtentReports extentReports = new ExtentReports();
    ExtentSparkReporter spark =  new ExtentSparkReporter(file);

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

        extentReports.attachReporter(spark);
        String path = new ActionHelper(driver).captureScreenshot("LoginPassed.jpg");

        extentReports
                .createTest("Login Test 2", "Successful login")
                .info("Info")
                .addScreenCaptureFromPath(path);

        extentReports.flush();

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
        Thread.sleep(1000);
        //assertFalse(loginPage.loginErrorVisible(), "Login successful");

        extentReports.attachReporter(spark);
        String path = new ActionHelper(driver).captureScreenshot("LoginFailed.jpg");

        extentReports
                .createTest("Login Test 1", "Failed login")
                .info("Info")
                .addScreenCaptureFromPath(path);

        extentReports.flush();

        assertTrue(loginPage.loginErrorVisible(), "The username or password is incorrect");

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
        Thread.sleep(2000);

        extentReports.attachReporter(spark);
        String path = new ActionHelper(driver).captureScreenshot("CartItem.jpg");

        extentReports
                .createTest("Add item to cart test", "Item added successfully")
                .info("Info")
                .addScreenCaptureFromPath(path);

        String newCartTotal = cart.cartTotal();
        assertNotEquals(oldCartTotal, newCartTotal, "Item added to cart successfully");

        extentReports.flush();

        products.clickMyAccount();
        products.logout();
    }

    @Test(priority = 4)
    public void testCheckout() throws InterruptedException {
        testSuccessfulLogin();
        products.openCart();
        cart.proceedToCheckout();

        checkout = new Checkout(driver);
        checkout.setFirstName("Lindokuhle");
        Thread.sleep(1000);
        checkout.setLastName("Nini");
        Thread.sleep(1000);
        checkout.setCompanyName("DigiLink");
        Thread.sleep(1000);
        checkout.selectCountryDropdown();
        Thread.sleep(1000);
        checkout.setCountryInputField("South Africa");
        Thread.sleep(1000);
        checkout.setCountry();
        Thread.sleep(1000);
        checkout.placeOrder();
        Thread.sleep(1000);

        confirmation = new Confirmation(driver);
        assertTrue(confirmation.orderSuccess().equals(true), "Order successful");
        assertFalse(confirmation.orderSuccess().equals(false), "Order unsuccessful");
        Thread.sleep(1000);

        products.clickMyAccount();
        confirmation.displayOrders();
        Thread.sleep(2000);
    }
}
