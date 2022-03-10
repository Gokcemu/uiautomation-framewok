package inventory;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.InventoryDetailsPage;

import static org.testng.Assert.assertEquals;
import static utils.Config.*;

public class InventoryTests extends BaseTests {


    @Test
    public void testBacktoProductsPage(){

        InventoryDetailsPage inventoryPage = productsPage.clickProductName(SAUCE_LABS_BACKPACK);
        inventoryPage.clickBackToProducts();
        assertEquals(productsPage.getPageTitle(), "PRODUCTS",
                "Return to Products Page Test Failed");
    }

    @Test
    public void testSelectInventoryItem(){
        InventoryDetailsPage inventoryDetailsPage = productsPage.clickProductName(SAUCE_LABS_BACKPACK);
        assertEquals(inventoryDetailsPage.getInventoryName(), SAUCE_LABS_BACKPACK,
                "Invalid inventory selected");
    }

}
