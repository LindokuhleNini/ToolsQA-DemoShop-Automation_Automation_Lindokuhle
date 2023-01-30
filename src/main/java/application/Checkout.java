package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ActionHelper;

public class Checkout extends ActionHelper {

    WebDriver driver;

    public Checkout(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void placeOrder(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        String elementId = "terms";
        WebElement element = driver.findElement(By.id(elementId));
        element.click();
        if(element.isSelected()){
            clickElement(By.id("place_order"));
        }
    }

}
