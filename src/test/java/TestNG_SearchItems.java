import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationPage;
import pages.ShoppingCartSummaryPage;
import utils.Config;

public class TestNG_SearchItems {
    AutomationPage mainPage = null;

    @BeforeMethod
    private void setUp(){
        mainPage = new AutomationPage();
        mainPage.setUp(Config.BASE_URI);
    }

    @Test
    public void testSearchingExistingItems() {
        String productForSearch = "Dress";
        try{
            Assert.assertTrue(mainPage.isMainPageIsVisible(), "Automation page doesn't shows correctly");
            Assert.assertTrue(mainPage.searchItems(productForSearch).size() > 0, "The items weren't found successfully!");
        } catch (AssertionError ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Test
    public void testSearchingNotExistingItems() {
        String productForSearch = "Qa Automation";
        try{
            Assert.assertTrue(mainPage.isMainPageIsVisible(), "Automation page doesn't shows correctly");
            Assert.assertTrue(mainPage.searchItems(productForSearch).size()==0, "The items weren't found successfully!");
            Assert.assertTrue(mainPage.isVisibleNotFoundItemsAlert(), "The items weren't found successfully!");

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
