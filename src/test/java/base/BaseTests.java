package base;

import application.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {

    private WebDriver driver;
    protected Home home;
    protected Dashboard dashboard;
    protected Products products;

    protected Cart cart;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://shop.demoqa.com/shop/");
        driver.manage().window().maximize();
        home = new Home(driver);
        home.removePopup();
        dashboard = new Dashboard(driver);
        products = new Products(driver);
        cart = new Cart(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}