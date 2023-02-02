package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ActionHelper;

public class Checkout extends ActionHelper {

    WebDriver driver;

    private By firstNameField = By.id("billing_first_name");
    private By lastNameField = By.id("billing_last_name");
    private By companyName = By.id("billing_company");
    private By countryDropdown = By.id("select2-billing_country-container");
    private By countryInputField = By.className("select2-search__field");
    private WebElement country = driver.findElement(By.linkText("South Africa"));
    private By street = By.id("billing_address_1");
    private By streetType = By.id("billing_address_2");
    private By city = By.id("billing_city");
    private By provinceDropdown = By.cssSelector("#select2-billing_state-container");
    private By provinceSearchbar = By.className("select2-search__field");
    private By provinceOptions = By.xpath("//*[@id=\"billing_state\"]");
    private By billingCode = By.id("billing_postcode");
    private By phone = By.id("billing_phone_field");
    private By email = By.id("billing_email_field");

    public Checkout(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
       driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setCompanyName(String company) {
        driver.findElement(companyName).sendKeys(company);
    }

    public void selectCountryDropdown() {
        driver.findElement(countryDropdown).click();
    }

 public void setCountryInputField(String country) {
        driver.findElement(countryInputField).sendKeys(country);
    }

    public void setCountry() {
        //driver.findElement(country).click();
        Select select = new Select(country);
        select.selectByVisibleText("South Africa");

    }

    public void setStreet(By street) {
        this.street = street;
    }

    public void setStreetType(By streetType) {
        this.streetType = streetType;
    }

    public void setCity(By city) {
        this.city = city;
    }

    public void setProvinceDropdown(By provinceDropdown) {
        this.provinceDropdown = provinceDropdown;
    }

    public void setProvinceSearchbar(By provinceSearchbar) {
        this.provinceSearchbar = provinceSearchbar;
    }

    public void setProvinceOptions(By provinceOptions) {
        this.provinceOptions = provinceOptions;
    }

    public void setBillingCode(By billingCode) {
        this.billingCode = billingCode;
    }

    public void setPhone(By phone) {
        this.phone = phone;
    }

    public void setEmail(By email) {
        this.email = email;
    }

    public void placeOrder(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        String elementId = "terms";
        WebElement element = driver.findElement(By.id(elementId));
        element.click();
        if(element.isSelected()){
            clickElement(By.id("place_order"));
        }
    }



}
