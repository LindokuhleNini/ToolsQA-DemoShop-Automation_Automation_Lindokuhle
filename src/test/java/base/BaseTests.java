package base;

import application.Dashboard;
import application.Home;
import application.Login;
import application.Products;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {

    private WebDriver driver;
    protected Home home;
    protected Dashboard dashboard;
    protected Products products;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://shop.demoqa.com");
        driver.manage().window().maximize();
        home = new Home(driver);
        dashboard = new Dashboard(driver);
        products = new Products(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}