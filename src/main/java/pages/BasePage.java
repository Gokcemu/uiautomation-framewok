package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;
    protected By burgerButton   = By.xpath("//div[@class='bm-burger-button']");
    protected By allItems       = By.id("inventory_sidebar_link");
    protected By about          = By.id("about_sidebar_link");
    protected By logout         = By.id("logout_sidebar_link");
    protected By resetAppState  = By.id("reset_sidebar_link");
    protected By closeBurgerButton = By.xpath("//div[@class='bm-cross-button']");
    protected By shoppingCart   = By.xpath("//a[@class='shopping_cart_link']");



    public BasePage(){
        this.driver = driver;
    }
}
