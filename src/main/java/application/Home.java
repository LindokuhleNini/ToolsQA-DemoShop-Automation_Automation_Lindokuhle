package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    private WebDriver driver;
    private By myAccountLink = By.linkText("My Account");

    public Home(WebDriver driver){
        this.driver = driver;
    }

    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public Login clickMyAccount(){
        clickLink("My Account");
        return new Login(driver);
    }
}
