package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button");
    private By errorMsg = By.className("woocommerce-notices-wrapper");


    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public Dashboard clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new Dashboard(driver);
    }

    public Boolean loginErrorVisible(){

        if (driver.findElement(errorMsg).isDisplayed())
        {
            return true;
        }
        return false;
    }

}
