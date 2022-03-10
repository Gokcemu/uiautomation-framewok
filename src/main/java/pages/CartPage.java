package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage {
    private WebDriver driver;
    private By quantity = By.xpath("//div[@class='cart_quantity_label']");
    private By description = By.xpath("//div[@class='cart_desc_label']");
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkOutButton = By.id("checkout");
    private By inventoryItems = By.xpath("//div[@class='inventory_item_name']");
    private By inventoryItemPrice = By.xpath("//div[@class='inventory_item_price']");
    private By inventoryItemDesc = By.xpath("//div[@class='inventory_item_desc']");
    private By removeInventoryButton = By.xpath("//button[@class='btn btn_secondary btn_small cart_button']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public ProductsPage clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
        return new ProductsPage(driver);
    }

    public CheckOutStepOnePage clickCheckOutButton() {
        driver.findElement(checkOutButton).click();
        return new CheckOutStepOnePage(driver);
    }

    public InventoryDetailsPage clickInventoryItems() {
        driver.findElement(inventoryItems).click();
        return new InventoryDetailsPage(driver);
    }

    private List<WebElement> getListedInventories() {
        return driver.findElements(inventoryItems);
    }

    private WebElement findInventory(String inventoryName) {
        List<WebElement> inventories = getListedInventories();
        for (WebElement inventory : inventories) {
            if (inventoryName.equals(inventory.findElement(inventoryItems).getText())) {
                return inventory;
            }
        }
        return null;
    }

    public String getInventoryName(String InventoryName){
        WebElement inventory = findInventory(InventoryName);
        return inventory.findElement(inventoryItems).getText();
    }

    public String getInventoryPrice(String InventoryName){
        WebElement inventory = findInventory(InventoryName);
        return inventory.findElement(inventoryItemPrice).getText();
    }

    public String getInventoryDesc(String InventoryName){
        WebElement inventory = findInventory(InventoryName);
        return inventory.findElement(inventoryItemDesc).getText();
    }

    public boolean checkProductinCart(String InventoryName){
        ExpectedConditions.invisibilityOfElementLocated(inventoryItems);
        return true;
    }

    public void removeProductCartButton(String InventoryName) {
        WebElement inventory = findInventory(InventoryName);
        inventory.findElement(removeInventoryButton).click();
    }

    public boolean removedProductDisappear(String InventoryName) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(inventoryItems));
        return true;
    }
}
