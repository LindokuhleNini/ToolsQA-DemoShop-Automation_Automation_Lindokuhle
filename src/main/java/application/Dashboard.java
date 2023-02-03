package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ActionHelper;

public class Dashboard extends ActionHelper {
    public WebDriver driver;

    public Dashboard(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void navigateToProducts(){

        clickElement(By.linkText("Downloads"));
        clickElement(By.linkText("Browse products"));

    }



}
