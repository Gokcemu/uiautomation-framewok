package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepOnePage extends BasePage {
    private WebDriver driver;
    private By checkOutStepOnePageTitle = By.xpath("//span[@class='title']");
    private By firstNameField  = By.id("first-name");
    private By lastNameField   = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By cancelButton    = By.id("cancel");
    private By continueButton  = By.id("continue");

    public CheckOutStepOnePage(WebDriver driver){
        this.driver = driver;
    }

    public String getCheckOutStepPageOneTitle(){
        return driver.findElement(checkOutStepOnePageTitle).getText();
    }

    public void setFirstNameField(String firstname){
        driver.findElement(firstNameField).sendKeys(firstname);
    }

    public void setLastNameField(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setPostalCodeField(String postalCode){
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public CheckOutStepTwoPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new CheckOutStepTwoPage(driver);
    }

    public CartPage clickCancelButton(){
        driver.findElement(cancelButton).click();
        return new CartPage(driver);
    }
}
