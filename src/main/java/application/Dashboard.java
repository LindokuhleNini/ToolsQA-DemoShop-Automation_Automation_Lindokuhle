package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard {
    private WebDriver driver;

    public Dashboard(WebDriver driver){
        this.driver = driver;
    }

    public Home clickHome(){
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/div/div/div/a/img")));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", firstResult);
        firstResult.click();
        return new Home(driver);
    }



}
