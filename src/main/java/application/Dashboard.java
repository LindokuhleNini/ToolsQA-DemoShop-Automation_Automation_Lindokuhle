package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ActionHelper;

public class Dashboard extends ActionHelper {
    private WebDriver driver;

    public Dashboard(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public Products navigateToProducts(){
      /*  driver.get("https://shop.demoqa.com/shop/");


        *//*JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", firstResult);
        firstResult.click();*//*
        return new Products(driver);*/

        clickElement(By.xpath("//*[@id=\"noo-site\"]"));
        return new Products(driver);
    }



}
