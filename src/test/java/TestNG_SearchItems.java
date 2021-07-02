import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationPO;
import utils.Config;

public class TestNG_SearchItems extends BaseTest {
    AutomationPO mainPage = null;

    @BeforeMethod
    private void setUp(){
        this.browserInitializer();
        this.setUp(Config.BASE_URI);
        mainPage = new AutomationPO(this.browser);
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
            Assert.assertEquals(mainPage.searchItems(productForSearch).size(), 0, "The items weren't found successfully!");
            Assert.assertTrue(mainPage.isVisibleNotFoundItemsAlert(), "The items weren't found successfully!");

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
