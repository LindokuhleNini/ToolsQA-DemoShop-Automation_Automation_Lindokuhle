import application.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.ActionHelper;
import utilities.ExcelHelper;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BaseTests {

    protected WebDriver driver;
    protected Products products;
    protected Dashboard dashboard;

    protected Checkout checkout;

    protected ExcelHelper excelHelper;

    protected Cart cart;
    protected Confirmation confirmation;

    protected String username;
    protected String password;


    @BeforeTest
    @Parameters({"browser", "url"})
    public void setUp(String browser, String url){

        driver = new ActionHelper(driver).setupBrowser(browser);
        driver.get(url);
        driver.manage().window().maximize();

        excelHelper = new ExcelHelper();
        excelHelper.excelSetup();
        products = new Products(driver);
        products.removePopup();

    }

    @AfterTest
    public void tearDown() throws IOException {
        driver.quit();
        Desktop.getDesktop().browse(new File("report.html").toURI());
    }
}