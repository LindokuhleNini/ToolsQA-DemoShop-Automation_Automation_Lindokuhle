package base;

import application.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.ActionHelper;
import utilities.ExcelHelper;

public class BaseTests {

    protected WebDriver driver;
    protected Products products;
    protected Dashboard dashboard;

    protected ExcelHelper excelHelper;

    protected Cart cart;

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

        cart = new Cart(driver);
        products.removePopup();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}