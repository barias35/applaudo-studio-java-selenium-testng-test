import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationPage;
import pages.ShoppingCartSummaryPage;
import utils.Config;

public class TestNG_DeleteItemFromShoppingCart {

    AutomationPage mainPage = null;
    @BeforeMethod
    private void setUp() {
        mainPage = new AutomationPage();
        mainPage.setUp(Config.BASE_URI);
    }

    @Test
    public void testDeletingItemInTheShoppingCart() {
            String productForSearch = "Shirt";
            try{
                Assert.assertTrue(mainPage.isMainPageIsVisible(), "Automation page doesn't shows correctly");
                Assert.assertTrue(mainPage.addItemToShoppingCart(productForSearch), "The item wasn't added succesfully to the cart!");
                ShoppingCartSummaryPage shoppingCartSummary = new ShoppingCartSummaryPage(mainPage.browser);
                shoppingCartSummary.deleteAddedProduct();
                System.out.println();

            } catch (AssertionError ex) {
                throw ex;
            } catch (Exception ex) {
                throw ex;
            }
        }

        @AfterMethod
        private void cleanUp() {

            if (mainPage != null)
                mainPage.tearDown();

        }
    }