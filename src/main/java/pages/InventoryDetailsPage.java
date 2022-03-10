package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryDetailsPage extends BasePage {

    private WebDriver driver;
    private By backToProductsButton = By.xpath("//div[@class='left_component']");
    private By addToCartButton = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
    private By removeButton = By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory']");
    private By inventoryName = By.xpath("//div[@class='inventory_details_name large_size']");
    private By inventortyPrice = By.xpath("//div[@class='inventory_details_price']");
    private By InventoryDesc = By.xpath("//div[@class='inventory_details_desc large_size']");


    public InventoryDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductsPage clickBackToProducts(){
        driver.findElement(backToProductsButton).click();
        return new ProductsPage(driver);
    }

    public String getInventoryName(){
        return driver.findElement(inventoryName).getText();
    }

    public String getInventoryDesc(){
        return driver.findElement(InventoryDesc).getText();
    }

    public String getInventoryPrice(){
        return driver.findElement(inventortyPrice).getText();
    }

    public void addInventoryToCart(){
        driver.findElement(addToCartButton).click();
    }

    public void removeInventoryFromCart(){
        driver.findElement(removeButton).click();
    }
}
