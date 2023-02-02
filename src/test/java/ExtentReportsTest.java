import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import utilities.ReportsHelper;

public class ExtentReportsTest {

    public WebDriver driver;
    public ExtentSparkReporter spark;
    public ExtentReportsTest extent;
    public ExtentTest logger;

    public void reports(){
        ReportsHelper extentReports = new ReportsHelper();

    }

//    @Test
//    public void startReport() {
//        // Create an object of Extent Reports
//        extent = new ExtentReports();
//
//        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
//        extent.attachReporter(spark);
//        extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
//        extent.setSystemInfo("Environment", "Production");
//        extent.setSystemInfo("User Name", "Rajkumar SM");
//        spark.config().setDocumentTitle("Title of the Report Comes here ");
//        // Name of the report
//        spark.config().setReportName("Name of the Report Comes here ");
//        // Dark Theme
//        spark.config().setTheme(Theme.STANDARD);
//    }
}
