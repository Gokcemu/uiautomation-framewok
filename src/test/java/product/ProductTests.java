package product;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.Assert.assertEquals;
import static utils.Config.SAUCE_LABS_BACKPACK;

public class ProductTests extends BaseTests {

    @Test
    public void addProducttoCart(){
        productsPage.clickAddProductToCart(SAUCE_LABS_BACKPACK);
        CartPage cartPage = productsPage.clickCartButton();
        cartPage.checkProductinCart(SAUCE_LABS_BACKPACK);
        assertEquals(cartPage.getInventoryName(SAUCE_LABS_BACKPACK), productsPage.getInventoryTitle(SAUCE_LABS_BACKPACK),
                "Invalid item added to cart");
    }
}
