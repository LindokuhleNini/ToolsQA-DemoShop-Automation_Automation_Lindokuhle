package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    private WebDriver driver;

    public Cart(WebDriver driver){
        this.driver = driver;
    }

    public String cartTotal(){
        return driver.findElement(By.className("woocommerce-Price-amount")).getText();
    }

}
