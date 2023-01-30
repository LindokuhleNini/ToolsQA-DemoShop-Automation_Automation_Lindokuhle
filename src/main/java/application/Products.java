package application;

import org.openqa.selenium.By;
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
    private By myAccountLink = By.linkText("My Account");

    public Products(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public void removePopup()
    {
        WebElement popup = driver.findElement(By.className("woocommerce-store-notice__dismiss-link"));
        WebElement closeBtn = driver.findElement(By.className("woocommerce-store-notice__dismiss-link"));

        if(popup.isDisplayed())
        {
            closeBtn.click();
        }
    }

    public void clickLink(String linkText)
    {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(By.linkText(linkText))).click();
    }

    public Login clickMyAccount()
    {
        clickElement(By.linkText("My Account"));
        return new Login(driver);
    }

    public void clickCart()
    {
        clickElement(By.className("cart-name-and-total"));
    }

    public void selectProduct(String prodTitle)
    {

        clickElement(By.linkText(prodTitle));
        /*wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        new Actions(driver).moveToElement(wait.until(ExpectedConditions.elementToBeClickable(By.linkText(prodTitle)))).click().build().perform();
*/
    }

    public void chooseColor(String color){
        clickElement(By.id("pa_color"));
        clickElement(By.linkText(color));
        /*WebElement colorOptions = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("pa_color")));
        colorOptions.click();
     clickLink(color);*/
    }

    public void chooseSize(String size){
        clickElement(By.id("pa_size"));
        clickElement(By.linkText(size));

      /*  WebElement sizeOptions = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("pa_size")));
        sizeOptions.click();
     clickLink(size);*/
    }

    public void addToCart(){
        clickElement(By.xpath("//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button"));
  /*      WebElement addButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button")));
        addButton.click();*/
    }

    public Cart openCart(){
        clickElement(By.className("cart-name-and-total"));
       /* WebElement addButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.className("cart-name-and-total")));
        addButton.click();*/

        return new Cart(driver);
    }


    public void logout(){
        clickElement(By.linkText("Logout"));
        //clickLink("Logout");
        //return new Login(driver);
    }
}
