package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReportsHelper {

    public static WebDriver driver;

    public static ExtentReports extentReports = new ExtentReports();
    public static ExtentSparkReporter spark =  new ExtentSparkReporter("report.html");

    public static void report() throws IOException {
        extentReports.attachReporter(spark);
        //File file = new File("report.html");

         ExtentTest test1 = extentReports.createTest("Test 1");
        test1.pass("This is passed");

        ExtentTest test2 = extentReports.createTest("Test 2");
        test2.log(Status.FAIL, "This is a failed test");

        extentReports.createTest("Test 3").skip("This is skipped");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        extentReports.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());
    }

    public static void main(String[] args) throws IOException {
        report();
    }
}
