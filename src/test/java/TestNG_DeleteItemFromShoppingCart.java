import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationPO;
import pages.ShoppingCartSummaryPO;
import utils.Config;

public class TestNG_DeleteItemFromShoppingCart extends BaseTest {

    AutomationPO mainPage = null;
    @BeforeMethod
    private void setUp() {
        this.browserInitializer();
        this.setUp(Config.BASE_URI);
        mainPage = new AutomationPO(this.browser);
    }

    @Test
    public void testDeletingItemInTheShoppingCart() {
            String itemForSearch = "Shirt";
            try{

                Assert.assertTrue(mainPage.isMainPageIsVisible(), "Automation page doesn't shows correctly");

                WebElement selectedItem = mainPage.selectRandomItem(itemForSearch);
                Assert.assertNotNull(selectedItem, "Random item couldn't be selected, please verify!");
                String itemName = selectedItem.getAttribute("alt");

                ShoppingCartSummaryPO shoppingCartSummaryPO = mainPage.addToCartSelectedItem(selectedItem);

                Assert.assertTrue(shoppingCartSummaryPO.isAddedSelectedItem(itemName),
                        String.format("The item %s wasn't added succesfully to the cart!", itemName));

                shoppingCartSummaryPO.deleteAddedItem();

                Assert.assertTrue(shoppingCartSummaryPO.isAddedItemDeleted(),
                        String.format("The Item %s wasn't deleted successfully", itemName));

            } catch (AssertionError ex) {
                throw ex;
            } catch (Exception ex) {
                throw ex;
            }
        }

        @AfterMethod
        private void cleanUp() {
            tearDown();
        }
    }