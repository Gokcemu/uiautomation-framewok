package checkout;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutStepOnePage;
import pages.CheckOutStepTwoPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Config.*;

public class CheckOutOrderTests extends BaseTests {


    @Test
    public void testAddProducttoCartandCheckout(){
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
    }
}
