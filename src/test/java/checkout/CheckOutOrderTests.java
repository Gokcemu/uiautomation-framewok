package checkout;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static utils.Config.*;

public class CheckOutOrderTests extends BaseTests {


    @Test
    public void testAddProducttoCartandCompleteCheckOut(){
        productsPage.clickAddProductToCart(SAUCE_LABS_BACKPACK);
        CartPage cartPage = productsPage.clickCartButton();
        CheckOutStepOnePage checkOutStepOnePage = cartPage.clickCheckOutButton();
        checkOutStepOnePage.setFirstNameField(FIRST_NAME);
        checkOutStepOnePage.setLastNameField(LAST_NAME);
        checkOutStepOnePage.setPostalCodeField(POSTAL_CODE);
        CheckOutStepTwoPage checkOutStepTwoPage = checkOutStepOnePage.clickContinueButton();
        assertEquals(checkOutStepTwoPage.getPaymentInformationValue(), "SauceCard #31337",
                "Not a valid payment cart");
        assertEquals(checkOutStepTwoPage.getShippingInformationValue(), "FREE PONY EXPRESS DELIVERY!",
                "Not a valid delivery");
        CheckOutCompletePage checkOutCompletePage = checkOutStepTwoPage.clickFinishButton();
        assertEquals(checkOutCompletePage.checkOutCompleteHeader(), "THANK YOU FOR YOUR ORDER",
                "Checkout order failed");
        ProductsPage productsPage = checkOutCompletePage.clickBackToProductButton();
    }

    @Test
    public void testCheckOutNullFirstName(){
        productsPage.clickAddProductToCart(SAUCE_LABS_BACKPACK);
        CartPage cartPage = productsPage.clickCartButton();
        CheckOutStepOnePage checkOutStepOnePage = cartPage.clickCheckOutButton();
        checkOutStepOnePage.setFirstNameField(NULL_USER);
        checkOutStepOnePage.setLastNameField(LAST_NAME);
        checkOutStepOnePage.setPostalCodeField(POSTAL_CODE);
        checkOutStepOnePage.clickContinueButton();
        assertEquals(checkOutStepOnePage.getErrorMessage(), "Error: First Name is required",
                "Check out null first name test failed");
        CartPage cartPage1 = checkOutStepOnePage.clickCancelButton();
        ProductsPage productsPage = cartPage1.clickContinueShopping();
    }

    @Test
    public void testCheckOutNullLastName(){
        productsPage.clickAddProductToCart(SAUCE_LABS_BACKPACK);
        CartPage cartPage = productsPage.clickCartButton();
        CheckOutStepOnePage checkOutStepOnePage = cartPage.clickCheckOutButton();
        checkOutStepOnePage.setFirstNameField(FIRST_NAME);
        checkOutStepOnePage.setLastNameField(NULL_USER);
        checkOutStepOnePage.setPostalCodeField(POSTAL_CODE);
        checkOutStepOnePage.clickContinueButton();
        assertEquals(checkOutStepOnePage.getErrorMessage(), "Error: Last Name is required",
                "Check out null last name test failed");
        CartPage cartPage1 = checkOutStepOnePage.clickCancelButton();
        ProductsPage productsPage = cartPage1.clickContinueShopping();
    }

    @Test
    public void testCheckOutNullPostalCode(){
        productsPage.clickAddProductToCart(SAUCE_LABS_BACKPACK);
        CartPage cartPage = productsPage.clickCartButton();
        CheckOutStepOnePage checkOutStepOnePage = cartPage.clickCheckOutButton();
        checkOutStepOnePage.setFirstNameField(FIRST_NAME);
        checkOutStepOnePage.setLastNameField(LAST_NAME);
        checkOutStepOnePage.setPostalCodeField(NULL_PASS);
        checkOutStepOnePage.clickContinueButton();
        assertEquals(checkOutStepOnePage.getErrorMessage(), "Error: Postal Code is required",
                "Check out null postal code test failed");
        CartPage cartPage1 = checkOutStepOnePage.clickCancelButton();
        ProductsPage productsPage = cartPage1.clickContinueShopping();
    }
}
