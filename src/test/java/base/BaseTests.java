package base;

import application.Home;
import application.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {

    private WebDriver driver;
    protected Home home;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://shop.demoqa.com/shop/");
        home = new Home(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}