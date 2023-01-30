package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.ActionHelper;

public class Cart extends ActionHelper {
    private WebDriver driver;

    public Cart(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public String cartTotal(){
        return driver.findElement(By.className("woocommerce-Price-amount")).getText();
    }

    public Checkout proceedToCheckout(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        clickElement(By.linkText("PROCEED TO CHECKOUT"));
        return new Checkout(driver);
    }


}
