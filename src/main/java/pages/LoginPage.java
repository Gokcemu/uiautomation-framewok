package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameField = By.xpath("//input[@placeholder='Username']");
    private By passwordField = By.xpath("//input[@placeholder='Password']");
    private By loginButton   = By.xpath("//input[@name='login-button']");
    private By errorAlert    = By.xpath("//div[@class='error-message-container error']");


    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

    public String getErrorAlert(){

        return driver.findElement(errorAlert).getText();
    }

    public void setUsernameField(String username){

        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPasswordField(String password){

        driver.findElement(passwordField).sendKeys(password);
    }

    public ProductsPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }
}
