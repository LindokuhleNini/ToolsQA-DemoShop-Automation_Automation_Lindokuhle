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
    private By countryInputField = By.xpath("//input[@role='combobox']");
    private By street = By.xpath("//input[@id='billing_address_1']");
    private By streetType = By.id("billing_address_2");
    private By cityField = By.id("billing_city");
    private By provinceDropdown = By.cssSelector("#select2-billing_state-container");
    private By provinceSearchbar = By.className("select2-search__field");
    private By provinceOptions = By.xpath("//*[@id=\"billing_state\"]");
    private By billingCode = By.id("billing_postcode");
    private By phone = By.xpath("//input[@id='billing_phone']");
    private By email = By.xpath("//input[@id='billing_email']");

    public Checkout(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
       driver.findElement(firstNameField).clear();
       driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setCompanyName(String company) {
        driver.findElement(companyName).clear();
        driver.findElement(companyName).sendKeys(company);
    }

    public void selectCountryDropdown() {
        //driver.findElement(countryDropdown).clear();
        driver.findElement(countryDropdown).click();
    }

 public void setCountryInputField(String country) {
        driver.findElement(countryInputField).sendKeys(country);
     driver.findElement(countryInputField).click();
    }

    public void setCountry() {
        //driver.findElement(country).click();
        WebElement country = driver.findElement(By.linkText("South Africa"));
        Select select = new Select(country);
        select.selectByVisibleText("South Africa");
    }

    public void setStreet(String str) {
        driver.findElement(street).clear();
        driver.findElement(street).sendKeys(str);
    }

    public void setStreetType(String type) {
        driver.findElement(streetType).clear();
        driver.findElement(streetType).sendKeys(type);
    }

    public void setCity(String city) {
        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);
    }

    public void selectProvinceDropdown() {
        driver.findElement(provinceDropdown).click();
    }

    public void setProvinceSearchbar(String province) {
        driver.findElement(provinceSearchbar).sendKeys(province);
        driver.findElement(provinceSearchbar).click();
    }

    public void setProvinceOptions(By provinceOptions) {
        this.provinceOptions = provinceOptions;
    }

    public void setBillingCode(String code) {
        driver.findElement(billingCode).clear();
        driver.findElement(billingCode).sendKeys(code);
    }

    public void setPhone(String phoneNum) {
        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys(phoneNum);
    }

    public void setEmail(String emailAddress) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(emailAddress);
    }

    public void placeOrder(){
        String elementId = "//input[@id='terms']";
        WebElement element = driver.findElement(By.xpath(elementId));
        element.click();

        //Check if Ts and Cs are selected
        if(element.isSelected()){

            //if selected, place order
            clickElement(By.id("place_order"));
        }
    }



}
