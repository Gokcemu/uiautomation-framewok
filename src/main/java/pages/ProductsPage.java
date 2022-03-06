package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    private By pageTitle      = By.xpath("//span[@class='title']");
    private By inventoryItems = By.xpath("//div[@class='inventory_item_name']");
    private By inventoryTitle = By.xpath("//div[@class='inventory_item_name']");
    private By inventoryItemPrice = By.xpath("//div[@class='inventory_item_price']");
    private By inventoryItemDesc = By.xpath("//div[@class='inventory_item_desc']");
    private By addToCartButton = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
    private By removeButton    = By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory']");
    private By sortContainer = By.xpath("//span[@class='select_container']");


    private WebDriver driver;


    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }


    public LoginPage clickLogout(){
        driver.findElement(burgerButton).click();
        driver.findElement(logout).click();
        return new LoginPage(driver);
    }

    public LoginPage returnLoginPage(){
        driver.navigate().back();
        return new LoginPage(driver);
    }

    public CartPage clickCartButton(){
        driver.findElement(shoppingCart).click();
        return new CartPage(driver);
    }

    public Select findSortContainerElement(){
        return new Select(driver.findElement(sortContainer));
    }

    public void selectFromSortContainer(String sortby) {
        findSortContainerElement().selectByVisibleText(sortby);
    }

    public List<String> getSelectedSortby(){
        List<WebElement> selectedSortBy = findSortContainerElement().getAllSelectedOptions();
        return selectedSortBy.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private List<WebElement> getListedInventories(){
        return driver.findElements(inventoryItems);
    }

    private WebElement findInventory(String inventoryName){
        List<WebElement> inventories = getListedInventories();
        for(WebElement inventory : inventories){
            if(inventoryName.equals(inventory.findElement(inventoryItems).getText())){
                return inventory;
            }
        }
        return null;
    }

    public void clickAddProductToCart(String inventoryName){
        WebElement inventory = findInventory(inventoryName);
        inventory.findElement(addToCartButton).click();
    }

    public InventoryDetailsPage clickProductName(String inventoryItemName){
        WebElement inventory = findInventory(inventoryItemName);
        inventory.findElement(inventoryItems).click();
        return new InventoryDetailsPage(driver);
    }
}
