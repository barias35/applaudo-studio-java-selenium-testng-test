import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationPO;
import pages.ShoppingCartSummaryPO;
import utils.Config;

import java.util.List;

public class TestNG_AddItemToShoppingCart extends BaseTest {

    AutomationPO mainPage = null;

    @BeforeMethod
    private void setUp(){
        //You can also initialize with ChromeOptions
        this.browserInitializer();
        this.setUp(Config.BASE_URI);
        mainPage = new AutomationPO(this.browser);
    }

    @Test
    public void testAddingItemToShoppingCart() {
        String productForSearch = "Dress";
        try{
            Assert.assertTrue(mainPage.isMainPageIsVisible(), "Automation page doesn't shows correctly");

            WebElement selectedItem = mainPage.selectRandomItem(productForSearch);
            Assert.assertNotNull(selectedItem, "Random item couldn't be selected, please verify!");
            String itemName = selectedItem.getAttribute("alt");
            mainPage.addToCartSelectedItem(selectedItem);
            ShoppingCartSummaryPO shoppingCartSummaryPO = mainPage.clickProcessToCheckOutButton();
            Assert.assertTrue(shoppingCartSummaryPO.isAddedSelectedItem(itemName),
                    String.format("The item %s wasn't added succesfully to the cart!", itemName));

        }catch (AssertionError ex){
            throw  ex;
        }catch (Exception ex){
            throw ex;
        }
    }

    @AfterMethod
    private void cleanUp(){
        this.tearDown();
    }
}
