package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static org.testng.Assert.*;
import static utils.Config.*;

public class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    private void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(LOGIN_URL);
        loginPage = new LoginPage(driver);
        driver.manage().window().fullscreen();
    }

    @AfterClass
    private void tearDown(){
        driver.quit();
    }

    @Test
    public void testNullUsernameandPassword(){

        loginPage = new LoginPage(driver);
        loginPage.setUsernameField(NULL_USER);
        loginPage.setUsernameField(NULL_PASS);
        loginPage.clickLoginButton();
        assertEquals(loginPage.getErrorAlert(),"Epic sadface: Username is required" ,
                "Null Username and Password test Failed");

    }

    @Test
    public void testWrongUsername(){

        loginPage.setUsernameField(FAIL_USER);
        loginPage.setPasswordField(DEFAULT_PASS);
        loginPage.clickLoginButton();
        assertEquals(loginPage.getErrorAlert(), "Epic sadface: Username and password do not match any user in this service",
                "Wrong Username test failed");

    }

    @Test
    public void testWrongPassword(){

        loginPage.setUsernameField(DEFAULT_USER);
        loginPage.setPasswordField(FAIL_PASS);
        loginPage.clickLoginButton();
        assertEquals(loginPage.getErrorAlert(), "Epic sadface: Username and password do not match any user in this service",
                "Wrong Password Test Failed");

    }

    @Test
    public void testSuccesfulLogin(){
        loginPage.setUsernameField(DEFAULT_USER);
        loginPage.setPasswordField(DEFAULT_PASS);
        ProductsPage productsPage = loginPage.clickLoginButton();
        assertEquals(productsPage.getPageTitle(), "PRODUCTS", "Login Failed");
        LoginPage loginPage = productsPage.returnLoginPage();
    }
}
