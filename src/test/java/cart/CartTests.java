package cart;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Config.SAUCE_LABS_BACKPACK;

public class CartTests extends BaseTests {
    @Test
    public void testSwitchCartPageSuccessful(){
        CartPage cartPage = productsPage.clickCartButton();
        assertEquals(cartPage.getCartPageTitle(), "YOUR CART",
                "Switch to the Cart Page Test Failed");
    }

    @Test
    public void testAddProductToCartandRemoveFromCart(){
        productsPage.clickAddProductToCart(SAUCE_LABS_BACKPACK);
        CartPage cartPage = productsPage.clickCartButton();
        cartPage.removeProductCartButton(SAUCE_LABS_BACKPACK);
        assertTrue(cartPage.removedProductDisappear(SAUCE_LABS_BACKPACK),
                "Add product to cart and remove from cart test failed");
    }
}
