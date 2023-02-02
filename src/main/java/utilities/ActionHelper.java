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
    WebElement el;

    File file = new File("report.html");
    ExtentReports extentReports = new ExtentReports();
    ExtentSparkReporter spark =  new ExtentSparkReporter(file);

    public ActionHelper(WebDriver driver){
        this.driver = driver;
    }
    public void clickElement(By element)
    {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element)).click();
        //element.sendKeys(Keys.DOWN);
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

    public void passedLoginScreenshot(){

        extentReports.attachReporter(spark);
        String path = captureScreenshot("LoginPassed.jpg");

        extentReports
                .createTest("Login Test 2", "Successful login")
                .info("Info")
                .addScreenCaptureFromPath(path);

        String path2 = captureScreenshot("LoginFailed.jpg");
        extentReports
                .createTest("Login Test 1", "Failed login")
                .info("Info")
                .addScreenCaptureFromPath(path2);

        extentReports.flush();
    }

    public void failedLoginScreenshot(){

        extentReports.attachReporter(spark);
        String path = captureScreenshot("LoginFailed.jpg");
        extentReports
                .createTest("Login Test 1", "Failed login")
                .info("Info")
                .addScreenCaptureFromPath(path);

        extentReports.flush();
    }

    public void cartScreenshot(){

        extentReports.attachReporter(spark);
        String path = captureScreenshot("CartSuccess.jpg");

        extentReports
                .createTest("Add item to cart test", "Item added successfully")
                .info("Info")
                .addScreenCaptureFromPath(path);

        extentReports.flush();
    }

    public String captureScreenshot(String fileName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/"+fileName);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot saved successfully");
        return destFile.getAbsolutePath();
    }

}
