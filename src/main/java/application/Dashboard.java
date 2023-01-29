package application;

import org.openqa.selenium.WebDriver;

public class Dashboard {
    private WebDriver driver;

    public Dashboard(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToProducts(){
        driver.get("https://shop.demoqa.com/shop/");


        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", firstResult);
        firstResult.click();*/
        //return new Products(driver);
    }



}
