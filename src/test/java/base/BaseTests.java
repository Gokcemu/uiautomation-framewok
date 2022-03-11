package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductsPage;

import java.sql.Driver;

import static utils.Config.*;

public class BaseTests {
    private static WebDriver driver;
    protected static LoginPage loginPage;
    protected static ProductsPage productsPage;

   @BeforeClass
   public static void setUp(){
       System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
       driver = new ChromeDriver();
       driver.get(LOGIN_URL);
       loginPage = new LoginPage(driver);
       loginPage.setUsernameField(DEFAULT_USER);
       loginPage.setPasswordField(DEFAULT_PASS);
       loginPage.clickLoginButton();
       productsPage = new ProductsPage(driver);
       driver.manage().window().fullscreen();
   }

        public static WebDriver getWebDriver(){
        return driver;
    }


   @AfterClass
    public static void tearDown(){
       driver.quit();
   }
}
