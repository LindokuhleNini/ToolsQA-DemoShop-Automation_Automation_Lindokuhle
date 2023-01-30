package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.ActionHelper;

public class Confirmation extends ActionHelper {
    WebDriver driver;
    public Confirmation(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void displayOrders(){
        clickElement(By.linkText("Orders"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }
}
