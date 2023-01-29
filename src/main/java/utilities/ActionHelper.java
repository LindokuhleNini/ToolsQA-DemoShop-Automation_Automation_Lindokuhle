package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionHelper {

    public WebDriver setupBrowser(String browser){
        WebDriver driver = null;

        switch (browser.toUpperCase()){
            case "CHROME", "GOOGLE CHROME" ->{
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                driver = new ChromeDriver();
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

}
