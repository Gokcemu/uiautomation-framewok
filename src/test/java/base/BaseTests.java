package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.ProductsPage;

import static utils.Config.*;

public class BaseTests {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;

   @BeforeClass
   public void setUp(){
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

   @AfterClass
    public void tearDown(){
       driver.quit();
   }

}
