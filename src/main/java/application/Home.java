package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home {
    private WebDriver driver;
    private WebDriverWait wait;
    private By myAccountLink = By.linkText("My Account");

    public Home(WebDriver driver)
    {
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
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText(linkText))).click();
    }

    public Login clickMyAccount()
    {
        clickLink("My Account");
        return new Login(driver);
    }

    public void clickCart()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.className("cart-name-and-total"))).click();
    }

    public Products selectProduct()
    {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        new Actions(driver).moveToElement(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[1]/a")))).click().build().perform();

        return new Products(driver);
    }
}
