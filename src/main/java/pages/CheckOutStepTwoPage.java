package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepTwoPage extends BasePage {

    private By cartQuantityLabel = By.xpath("//div[@class='cart_quantity_label']");
    private By cartDescLabel = By.xpath("//div[@class='cart_desc_label']");
    private By paymentInformation = By.xpath("//div[text()='Payment Information:']");
    private By paymentInformationValue = By.xpath("//div[text()='SauceCard #31337']");
    private By shippingInformation = By.xpath("//div[text()='Shipping Information:']");
    private By shippingInformationValue = By.xpath("//div[text()='FREE PONY EXPRESS DELIVERY!']");
    private By summarySubTotalValue = By.xpath("//div[@class='summary_subtotal_label']");
    private By summaryTaxValue = By.xpath("//div[@class='summary_tax_label']");
    private By summaryTotalValue = By.xpath("//div[@class='summary_total_label']");
    private By finishButton = By.id("finish");
    private By cancelButton = By.id("cancel");

    public CheckOutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public String getPaymentInformationValue(){
        return driver.findElement(paymentInformationValue).getText();
    }

    public String getShippingInformationValue(){
        return driver.findElement(shippingInformationValue).getText();
    }

    public String getSubTotalValue(){
        return driver.findElement(summarySubTotalValue).getText();
    }

    public String getTaxValue(){
        return driver.findElement(summaryTaxValue).getText();
    }

    public String getTotalValue(){
        return driver.findElement(summaryTotalValue).getText();
    }

    public CheckOutCompletePage clickFinishButton(){
        driver.findElement(finishButton).click();
        return new CheckOutCompletePage(driver);
    }

    public ProductsPage clickCancelButton(){
        driver.findElement(cancelButton).click();
        return new ProductsPage(driver);
    }

}
