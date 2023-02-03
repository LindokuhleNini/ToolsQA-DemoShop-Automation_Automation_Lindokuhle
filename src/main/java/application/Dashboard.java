package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.ActionHelper;

public class Dashboard extends ActionHelper {
    public WebDriver driver;

    public Dashboard(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void navigateToProducts(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        clickElement(By.linkText("Downloads"));
        clickElement(By.linkText("Browse products"));

    }



}
