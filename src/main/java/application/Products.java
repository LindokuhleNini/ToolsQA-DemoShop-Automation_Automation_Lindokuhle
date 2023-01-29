package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Products {
    private WebDriver driver;

    public Products(WebDriver driver){
        this.driver = driver;
    }

    public void chooseColor(){
        WebElement colorOptions = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("pa_color")));
        colorOptions.click();

        WebElement color = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pa_color\"]/option[2]")));
        color.click();

        //return new Home(driver);
    }

    public void chooseSize(){
        WebElement sizeOptions = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("pa_size")));
        sizeOptions.click();

        WebElement size = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pa_size\"]/option[2]")));
        size.click();

        //return new Home(driver);
    }

    public void addToCart(){
        WebElement addButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button")));
        addButton.click();
    }

    public Cart openCart(){
        WebElement addButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.className("cart-name-and-total")));
        addButton.click();

        return new Cart(driver);
    }


}
