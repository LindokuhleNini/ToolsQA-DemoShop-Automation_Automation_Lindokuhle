package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ActionHelper;

import java.time.Duration;

public class Products extends ActionHelper {
    private WebDriver driver;
    private WebDriverWait wait;

    public Products(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public void removePopup()
    {
        WebElement popup = driver.findElement(By.className("woocommerce-store-notice__dismiss-link"));
        WebElement closeBtn = driver.findElement(By.className("woocommerce-store-notice__dismiss-link"));

        //dismiss popup
        if(popup.isDisplayed())
        {
            closeBtn.click();
        }
    }

    public Login clickMyAccount()
    {
        clickElement(By.linkText("My Account"));
        return new Login(driver);
    }

    public void selectProduct(String prodTitle)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        clickElement(By.linkText(prodTitle));
    }

    public void chooseColor(String color){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        clickElement(By.id("pa_color"));
        clickElement(By.xpath("//*[text()='"+color+"']"));

    }

    public void chooseSize(String size){

        clickElement(By.id("pa_size"));
        clickElement(By.xpath("//*[text()='"+size+"']"));

    }

    public void addToCart(){

        clickElement(By.className("single_add_to_cart_button"));

    }

    public Cart openCart(){

        clickElement(By.className("cart-name-and-total"));
        return new Cart(driver);
    }

    public void logout(){

        clickElement(By.linkText("Logout"));

    }
}
