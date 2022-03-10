package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage extends BasePage {

    private WebDriver driver;
    private By checkOutCompleteHeader = By.xpath("//h2[@class='complete-header']");
    private By backToProductsButton = By.id("back-to-products");

    public CheckOutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCheckOutCompleteTitle(){
        return driver.findElement(pageTitle).getText();
    }

    public String checkOutCompleteHeader(){
        return driver.findElement(checkOutCompleteHeader).getText();
    }

    public ProductsPage clickBackToProductButton(){
        driver.findElement(backToProductsButton).click();
        return new ProductsPage(driver);
    }
}
