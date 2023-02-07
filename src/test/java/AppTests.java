import application.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class AppTests extends BaseTests {

    File file = new File("report.html");
    ExtentReports extentReports = new ExtentReports();
    ExtentSparkReporter spark =  new ExtentSparkReporter(file);

    boolean firstLogin = true;


    @Test(priority = 2)
    public void testSuccessfulLogin() throws InterruptedException {
        username = excelHelper.getCellDataString(2, 1);
        password = excelHelper.getCellDataString(2, 2);

        extentReports.attachReporter(spark);
        ExtentTest parentTest = extentReports.createTest("Valid Login");

        Login loginPage = products.clickMyAccount();
        Thread.sleep(1000);
        loginPage.setUsername(username);
        Thread.sleep(1000);
        loginPage.setPassword(password);
        parentTest.info("User provides correct login details");
        parentTest.addScreenCaptureFromPath(reportsHelper.captureScreenshot("Correct_login_credentials.jpg"));
        loginPage.clickLoginButton();

        parentTest.log(Status.PASS, "User is logged in successfully");
        parentTest.addScreenCaptureFromPath(reportsHelper.captureScreenshot("logged_in.jpg"));
        extentReports.flush();

        assertFalse(loginPage.loginErrorVisible(),
                "Login Credentials are correct");
    }

    @Test(priority = 1)
    public void testUnsuccessfulLogin() throws InterruptedException {
        username = excelHelper.getCellDataString(1, 1);
        password = excelHelper.getCellDataString(1, 2);

        extentReports.attachReporter(spark);
        ExtentTest parentTest = extentReports.createTest("Invalid Login");

        Login loginPage = products.clickMyAccount();
        Thread.sleep(1000);
        loginPage.setUsername(username);
        Thread.sleep(1000);
        loginPage.setPassword(password);
        Thread.sleep(1000);
        parentTest.info("User provides incorrect login details");
        parentTest.addScreenCaptureFromPath(reportsHelper.captureScreenshot("wrong_login_credentials.jpg"));

        loginPage.clickLoginButton();
        Thread.sleep(1000);

        parentTest.log(Status.FAIL, "User gets an error message");
        parentTest.addScreenCaptureFromPath(reportsHelper.captureScreenshot("login_error.jpg"));
        extentReports.flush();

        assertTrue(loginPage.loginErrorVisible(), "The username or password is incorrect");

    }

    @Test(priority = 3)
    public void testItemAddedToCart() throws InterruptedException {

        extentReports.attachReporter(spark);
        ExtentTest parentTest = extentReports.createTest("Add Item To Cart");

        dashboard = new Dashboard(driver);
        cart = new Cart(driver);
        dashboard.navigateToProducts();

        parentTest.info("User is able to navigate to products");
        parentTest.addScreenCaptureFromPath(reportsHelper.captureScreenshot("got2products.jpg"));

        String prodTitle = excelHelper.getCellDataString(2, 3);
        String color = excelHelper.getCellDataString(2, 4);
        String size = ""+excelHelper.getCellDataInt(2, 5);

        products.selectProduct(prodTitle.toUpperCase());
        parentTest.info("User is able to select product");
        parentTest.addScreenCaptureFromPath(reportsHelper.captureScreenshot("product.jpg"));

        String oldCartTotal = cart.cartTotal();
        products.chooseColor(color);
        products.chooseSize(size);
        Thread.sleep(1000);
        parentTest.info("Choose product size and color");
        parentTest.addScreenCaptureFromPath(reportsHelper.captureScreenshot("prod_details.jpg"));

        products.addToCart();
        parentTest.log(Status.PASS, "Add product to cart");
        parentTest.addScreenCaptureFromPath(reportsHelper.captureScreenshot("add2cart.jpg"));
        Thread.sleep(1000);

        extentReports.flush();

        String newCartTotal = cart.cartTotal();
        assertNotEquals(oldCartTotal, newCartTotal, "Item added to cart successfully");

    }

    @Test(priority = 4)
    public void testLogout(){
        extentReports.attachReporter(spark);
        ExtentTest parentTest = extentReports.createTest("Logout");

        products.clickMyAccount();
        products.logout();
        parentTest.info("User is logged out");
        parentTest.addScreenCaptureFromPath(reportsHelper.captureScreenshot("logout.jpg"));
        extentReports.flush();
    }

    @Test(priority = 5)
    public void testSuccessfulCheckout() throws InterruptedException {
        testSuccessfulLogin();
        testItemAddedToCart();
        extentReports.attachReporter(spark);
        ExtentTest parentTest = extentReports.createTest("Checkout Test");

        //testSuccessfulLogin();
        products.openCart();
        cart.proceedToCheckout();

        String firstName = excelHelper.getCellDataString(3, 1);
        String lastName = excelHelper.getCellDataString(3, 2);
        String company = excelHelper.getCellDataString(3, 8);
        String streetAddress = excelHelper.getCellDataString(3, 10);
        //String addressType = ""+excelHelper.getCellDataInt(3, 5);
        String city = excelHelper.getCellDataString(3, 11);
        String code = ""+excelHelper.getCellDataInt(3, 13);
        String phone = ""+excelHelper.getCellDataInt(3, 14);
        String email = excelHelper.getCellDataString(3, 15);

        checkout = new Checkout(driver);
        checkout.setFirstName(firstName);
        Thread.sleep(1000);
        checkout.setLastName(lastName);
        Thread.sleep(1000);
        checkout.setCompanyName(company);
        Thread.sleep(1000);

        /*checkout.selectCountryDropdown();
        Thread.sleep(1000);
        checkout.setCountry();
        Thread.sleep(1000);*/

        checkout.setStreet(streetAddress);
        Thread.sleep(1000);
        checkout.setCity(city);
        Thread.sleep(1000);

        /*checkout.selectProvinceDropdown();
        Thread.sleep(1000);*/
        /*checkout.setProvinceSearchbar("Western Cape");
        Thread.sleep(1000);*/

        checkout.setBillingCode(code);
        Thread.sleep(1000);

        checkout.setPhone(phone);
        Thread.sleep(1000);
        checkout.setEmail(email);
        Thread.sleep(1000);

        parentTest.info("All mandatory fields are filled in");
        parentTest.addScreenCaptureFromPath(reportsHelper.captureScreenshot("checkout.jpg"));

        checkout.placeOrder();
        Thread.sleep(2000);

        confirmation = new Confirmation(driver);
        /*assertTrue(confirmation.orderSuccess().equals(true), "Order successful");
        assertFalse(confirmation.orderSuccess().equals(false), "Order unsuccessful");
        Thread.sleep(1000);*/

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        parentTest.info("Order is placed");
        parentTest.addScreenCaptureFromPath(reportsHelper.captureScreenshot("order_conf.jpg"));

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-500)");
        products.clickMyAccount();
        confirmation.displayOrders();
        parentTest.info("Display orders");
        parentTest.addScreenCaptureFromPath(reportsHelper.captureScreenshot("orders.jpg"));
        extentReports.flush();
        Thread.sleep(2000);
    }
}
