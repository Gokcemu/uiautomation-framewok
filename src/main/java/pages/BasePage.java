package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected  WebDriver driver;

    protected By pageTitle = By.xpath("//span[@class='title']");
    protected By burgerButton   = By.xpath("//div[@class='bm-burger-button']");
    protected By allItems       = By.id("inventory_sidebar_link");
    protected By about          = By.id("about_sidebar_link");
    protected By logout         = By.id("logout_sidebar_link");
    protected By resetAppState  = By.id("reset_sidebar_link");
    protected By closeBurgerButton = By.xpath("//div[@class='bm-cross-button']");
    protected By shoppingCart   = By.xpath("//a[@class='shopping_cart_link']");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickBurgerMenuButton(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(burgerButton)).click();
    }

    public void clickResetAppStateButton(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetAppState)).click();
    }
}
