import application.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utilities.ActionHelper;
import utilities.ExcelHelper;
import utilities.ReportsHelper;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BaseTests {

    protected WebDriver driver;
    protected ReportsHelper reportsHelper;
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

        //setup browser
        driver = new ActionHelper(driver).setupBrowser(browser);
        driver.get(url);
        driver.manage().window().maximize();

        //setup Excel
        excelHelper = new ExcelHelper();
        excelHelper.excelSetup();

        //Dismiss top popup on website
        products = new Products(driver);
        products.removePopup();

        //initialise extent report class
        reportsHelper = new ReportsHelper(driver);

    }

    @AfterTest
    public void tearDown() throws IOException {
        driver.quit();

        //Display extent report on browser
        Desktop.getDesktop().browse(new File("report.html").toURI());
    }
}