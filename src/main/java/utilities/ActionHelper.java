package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.devtools.v107.page.Page.captureScreenshot;

public class ActionHelper {
    WebDriver driver;

    public ActionHelper(WebDriver driver){
        this.driver = driver;
    }
    public void clickElement(By element)
    {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public WebDriver setupBrowser(String browser){

        switch (browser.toUpperCase()){
            case "CHROME", "GOOGLE CHROME" ->{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "EDGE", "MICROSOFT EDGE" ->{
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        driver.manage().window().maximize();
        return driver;
    }


}
